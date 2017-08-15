package com.deloitte.ucl.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskManagerController {

	// @Autowired
	// CaseService caseService;
	// TaskManagerService taskmanagerservice = new TaskManagerService();

	private static final Logger logger = LoggerFactory.getLogger(TaskManagerController.class);

	// CaseService caseService = new CaseService();

	// @RequestMapping(value = "/getCaseData", method = RequestMethod.GET,
	// headers = "Accept=application/json")
	// public DcCases getCaseData() {
	// long casenum = 1010030539 ;
	// Debug.print("Came here-------------");
	// // DcCasesCargo[] cases = caseService.getDcCasesData(casenum);
	// DcCases dcCase = new DcCases();
	// SimpleDateFormat sp = new SimpleDateFormat("mm/dd/yyyy");
	// dcCase.setAppRecvdDt(sp.format(cases[0].getAppRecvdDt()));
	// dcCase.setAuthrepFirstName(cases[0].getAuthrepFirstName());
	// dcCase.setAuthrepLastName(cases[0].getAuthrepLastName());
	// dcCase.setCaseNum(casenum);
	//
	//
	// return dcCase;
	// }

	@RequestMapping(value = "/getComments", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<String> getComments() {
		// DcIndvCommentsCargo[] comments = caseService.getComments();
		List<String> comment = new ArrayList<String>();

		// for(DcIndvCommentsCargo cargo : comments) {
		// comment.add(cargo.getCommentsTxt());
		// }

		logger.error("**********inside logger");

		// int a = 10;
		// if(a==10){throw new CustomBusinessException("100", "error");}
		//

		return comment;
	}

	// @RequestMapping(value="/insertComment", method=RequestMethod.POST)
	// public String insertComments(@RequestBody DcComments comment,
	// HttpServletRequest req) {
	//
	// Map sessionInfo = new HashMap();
	// IContexts contexts =
	// (IContexts)FwServiceFactory.getInstance().create(IContexts.class);
	// sessionInfo.put(FwConstants.SESSION_ID, req.getSession().getId());
	// //if(serviceId != null && serviceId.length() > 20) serviceId =
	// serviceId.substring(0,20);
	// sessionInfo.put(FwConstants.SESSION_USER_ID, "abcd");
	// contexts.createContext(sessionInfo);
	// contexts.setSession(req.getSession().getId());
	// caseService.insertComment(comment.getComment());
	// return "{\"response\":\"success\"}";
	// }

	/*
	 * @RequestMapping(value = "/tasks", method = RequestMethod.GET, headers =
	 * "Accept=application/json") public List<Task> getAllTasks() { List<Task>
	 * tasks = taskmanagerservice.getAllTasks(); long casenum = 123456;
	 * DcCasesCargo[] tasks1 = caseService.getDcCasesData(casenum);
	 * List<DcCasesCargo> caseList = Arrays.asList(tasks1);
	 * logger.info(caseList); return tasks; }
	 * 
	 * @RequestMapping(value = "/tasks/archive/{taskIds}", method =
	 * RequestMethod.POST, headers = "Accept=application/json") public
	 * List<Task> archiveAllTasks(@PathVariable int[] taskIds) { for (int i = 0;
	 * i < taskIds.length; i++) { taskmanagerservice.archiveTask(taskIds[i]); }
	 * List<Task> tasks = taskmanagerservice.getAllTasks(); return tasks; }
	 * 
	 * @RequestMapping(value = "/tasks/{taskId}/{taskStatus}", method =
	 * RequestMethod.POST, headers = "Accept=application/json") public
	 * List<Task> changeTaskStatus(@PathVariable int taskId,
	 * 
	 * @PathVariable String taskStatus) throws ParseException {
	 * taskmanagerservice.changeTaskStatus(taskId, taskStatus); return
	 * taskmanagerservice.getAllTasks(); }
	 * 
	 * @RequestMapping(value =
	 * "/tasks/insert/{taskName}/{taskDesc}/{taskPriority}/{taskStatus}", method
	 * = RequestMethod.POST, headers = "Accept=application/json") public
	 * List<Task> addTask(@PathVariable String taskName,
	 * 
	 * @PathVariable String taskDesc, @PathVariable String taskPriority,
	 * 
	 * @PathVariable String taskStatus) throws ParseException { Task task = new
	 * Task(); task.setTaskName(taskName); task.setTaskDescription(taskDesc);
	 * task.setTaskPriority(taskPriority); task.setTaskStatus(taskStatus);
	 * taskmanagerservice.addTask(task); return
	 * taskmanagerservice.getAllTasks(); }
	 */
}
