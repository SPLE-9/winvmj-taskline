package taskline.project.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="project_impl")
@Table(name="project_impl")
public class ProjectImpl extends ProjectComponent {

	public ProjectImpl(UUID projectId, String title, String description, double completion) {
		this.projectId = projectId;
		this.title = title;
		this.description = description;
		this.completion = completion;
	}

	public ProjectImpl(String title, String description, double completion) {
		this.projectId = UUID.randomUUID();
		this.title = title;
		this.description = description;
		this.completion = completion;
	}

	public ProjectImpl(String title, String description) {
		this.projectId = UUID.randomUUID();
		this.title = title;
		this.description = description;
		this.completion = 0;
	}

	public ProjectImpl() {
		this.projectId = UUID.randomUUID();
		this.title = "";
		this.description = "";
		this.completion = 0;
	}

}
