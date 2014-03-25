package com.b2.ankiety;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

public class AnswerSearchCriteria {

	private Long QuestionId;
	private Long ChoiceId;
	private boolean interested;
	
	public AnswerSearchCriteria(Long questionId, Long choiceId, boolean interested) {
		QuestionId = questionId;
		ChoiceId = choiceId;
		this.interested = interested;
	}

	public static Set<AnswerSearchCriteria> getSearchIds(HttpServletRequest request) {
		Set<AnswerSearchCriteria> s = new HashSet<AnswerSearchCriteria>(); 
		
		@SuppressWarnings("rawtypes")
		Enumeration e = request.getParameterNames();
		while (e.hasMoreElements()) {
			String name = (String) e.nextElement();
			String value = request.getParameter(name);
			
            if (name.startsWith("q_")) {
            	String questionId = name.substring(2);
            	
            	if (value.equals("0") && request.getParameter("i_" + questionId)==null) {

            		continue;
            	}
            	AnswerSearchCriteria asc = new AnswerSearchCriteria(Long.valueOf(questionId), Long.valueOf(value), request.getParameter("i_" + questionId)!=null);
            	s.add(asc);
            }
		}		

		return s;
	}	
	
	
	public AnswerSearchCriteria() {
		
	}
	public Long getQuestionId() {
		return QuestionId;
	}
	public void setQuestionId(Long questionId) {
		QuestionId = questionId;
	}
	public Long getChoiceId() {
		return ChoiceId;
	}
	public void setChoiceId(Long choiceId) {
		ChoiceId = choiceId;
	}
	public boolean isInterested() {
		return interested;
	}
	public void setInterested(boolean interested) {
		this.interested = interested;
	}

	@Override
	public String toString() {
		return "AnswerSearchCriteria [QuestionId=" + QuestionId + ", ChoiceId="
				+ ChoiceId + ", interested=" + interested + "]";
	}
	
}
