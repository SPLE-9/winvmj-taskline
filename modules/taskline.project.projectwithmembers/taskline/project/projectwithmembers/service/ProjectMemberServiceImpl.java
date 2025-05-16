package taskline.project.projectwithmembers;

import java.util.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import taskline.project.projectwithmembers.ProjectMemberFactory;

import taskline.member.core.*;
import taskline.project.core.*;

public class ProjectMemberServiceImpl extends ProjectMemberServiceComponent {
    private ProjectMemberFactory projectMemberFactory = new ProjectMemberFactory();

    ProjectService projectService = new ProjectServiceImpl();
    MemberService memberService = new MemberServiceImpl();

	public HashMap<String,Object> saveProjectMember(Map<String, Object> requestBody) {
        if (!requestBody.containsKey("projectId")) {
            throw new FieldValidationException("Field 'projectId' not found in the request body.");
        }

		String projectIdStr = (String) requestBody.get("projectId");
        UUID projectId = UUID.fromString(projectIdStr);
        Project project = projectService.getProjectById(projectId);

		if (!requestBody.containsKey("memberId")) {
            throw new FieldValidationException("Field 'memberId' not found in the request body.");
        }

		String memberIdStr = (String) requestBody.get("memberId");
        UUID memberId = UUID.fromString(memberIdStr);
        Member member = memberService.getMemberById(memberId);

        UUID projectMemberId = UUID.randomUUID();

		ProjectMember projectMember = projectMemberFactory.createProjectMember("taskline.project.projectwithmembers.ProjectMemberImpl", projectMemberId, project, member);
		projectMemberRepository.saveObject(projectMember);
		
		return projectMemberRepository.getObject(projectMemberId).toHashMap();
	}

    public List<HashMap<String,Object>> deleteProjectMember(Map<String, Object> requestBody) {
		String projectMemberIdStr = (String) requestBody.get("projectMemberId");
    	UUID projectMemberId = UUID.fromString(projectMemberIdStr);
		
		ProjectMember projectMember = projectMemberRepository.getObject(projectMemberId);
		if (projectMember == null) {
			throw new NotFoundException("ProjectMember with projectMemberId " + projectMemberId +" not found");
		}

        UUID projectId = projectMember.getProject().getProjectId();

		projectMemberRepository.deleteObject(projectMemberId);

		return getProjectMembers(projectId.toString());
	}

    public List<HashMap<String,Object>> getProjectMembers(String projectIdStr) {
        UUID projectId = UUID.fromString(projectIdStr);
        List<ProjectMember> projectMemberList = projectMemberRepository.getListObject("projectmember_comp", "project_projectId", projectId);
        return transformListToHashMap(projectMemberList);
	}

    public List<HashMap<String,Object>> getProjectsByMember(String memberEmail) {
        Member member = memberService.getMemberByEmail(memberEmail);
        List<ProjectMember> projectMemberList = projectMemberRepository.getListObject("projectmember_comp", "member_memberId", member.getMemberId());

        List<Project> projectList = new ArrayList<Project>();
        for(ProjectMember projectMember : projectMemberList) {
            projectList.add(projectMember.getProject());
        }

        return projectService.transformListToHashMap(projectList);
	}

	public List<HashMap<String, Object>> transformListToHashMap(List<ProjectMember> projectMemberList) {
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(ProjectMember projectMember : projectMemberList) {
            resultList.add(projectMember.toHashMap());
        }

        return resultList;
	}
    
}
