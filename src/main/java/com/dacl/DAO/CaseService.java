//package com.deloitte.ucl.DAO;
//
//import us.mi.state.dhs.bridges.business.entities.cases.DcCasesCargo;
//import us.mi.state.dhs.bridges.business.entities.cases.DcCasesCollection;
//import us.mi.state.dhs.bridges.business.entities.individual.DcIndvCommentsCargo;
//import us.mi.state.dhs.bridges.business.entities.individual.DcIndvCommentsCollection;
//import us.mi.state.dhs.fw.business.exceptions.ApplicationException;
//import us.mi.state.dhs.fw.business.exceptions.FrameworkException;
//import us.mi.state.dhs.fw.business.exceptions.TIERSRunTimeException;
//import us.mi.state.dhs.fw.business.exceptions.TIERSValidationException;
//
//import org.springframework.stereotype.Service;
//
//@Service
//public class CaseService {
//	
//	public DcCasesCargo[] getDcCasesData(long caseNum) {
//		DcCasesCargo cargo = new DcCasesCargo();
//		DcCasesCollection coll =  new DcCasesCollection();
//		cargo.setCaseNum(caseNum);
//		coll.setCargo(cargo);
//
//	     try {
//			return (DcCasesCargo[]) coll.select("findByCaseNum");
//		} catch (ApplicationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (FrameworkException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	     return null;
//	}
//	
//	public String insertComment(String comment) {
//		DcIndvCommentsCargo cmnt = new DcIndvCommentsCargo();
//		cmnt.setCommentsTxt(comment);
//		cmnt.setKeyType("SSAPM");
//		cmnt.setKeyOne(0);
//		cmnt.setKeyTwo("T11047870");
//		//cmnt.setCommentsSeq(11065);
//		DcIndvCommentsCollection coll = new DcIndvCommentsCollection();
//		coll.setCargo(cmnt);
//		try {
//			coll.insert(coll);
//			return "success";
//		} catch (TIERSRunTimeException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (TIERSValidationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return "fail";
//	}
//	
//	public DcIndvCommentsCargo[] getComments() {
//		DcIndvCommentsCargo cmnt = new DcIndvCommentsCargo();
//		DcIndvCommentsCollection coll = new DcIndvCommentsCollection();
//		
//		cmnt.setKeyOne(111047870);
//		cmnt.setKeyType("SSAPM");
//		
//		coll.setCargo(cmnt);
//		try {
//			return (DcIndvCommentsCargo[])coll.select("findByCaseNumForSS");
//		} catch (ApplicationException e) {
//			e.printStackTrace();
//		} catch (FrameworkException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//}
