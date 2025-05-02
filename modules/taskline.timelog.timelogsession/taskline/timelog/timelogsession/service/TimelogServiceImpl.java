package taskline.timelog.timelogsession;

import java.util.*;

import vmj.routing.route.VMJExchange;

import taskline.timelog.core.TimelogServiceDecorator;
import taskline.timelog.core.TimelogImpl;
import taskline.timelog.core.TimelogServiceComponent;

public class TimelogServiceImpl extends TimelogServiceDecorator {
    public TimelogServiceImpl (TimelogServiceComponent record) {
        super(record);
    }

    
	public void calculateTotalDuration() {
		// TODO: implement this method
		List<TimelogTimelogSession> sessions = timelogtimelogsessionRepository.getAllObject("timelogtimelogsession_impl");

        for (TimelogTimelogSession session : sessions) {
            if (session instanceof TimelogImpl) {
                TimelogImpl impl = (TimelogImpl) session;
                long duration = impl.calculateTotalDuration();
                System.out.println("Session ID: " + impl.getId() + " — Duration (minutes): " + duration);
            }
        }
	}

	public void getIsOnGoing() {
		// TODO: implement this method
		List<TimelogTimelogSession> sessions = timelogtimelogsessionRepository.getAllObject("timelogtimelogsession_impl");

        for (TimelogTimelogSession session : sessions) {
            if (session instanceof TimelogImpl) {
                TimelogImpl impl = (TimelogImpl) session;
                boolean ongoing = impl.getIsOnGoing();
                System.out.println("Session ID: " + impl.getId() + " — Is Ongoing: " + ongoing);
            }
        }
	}

	public void endSession() {
		// TODO: implement this method
		List<TimelogTimelogSession> sessions = timelogtimelogsessionRepository.getAllObject("timelogtimelogsession_impl");

        for (TimelogTimelogSession session : sessions) {
            if (session instanceof TimelogImpl) {
                TimelogImpl impl = (TimelogImpl) session;
                if (impl.getIsOnGoing()) {
                    impl.endSession();
                    timelogtimelogsessionRepository.updateObject(impl);
                    System.out.println("Ended session ID: " + impl.getId());
                }
            }
        }
	}
}
