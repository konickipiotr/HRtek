package com.hrtek.user.display.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hrtek.user.display.views.BasicView;

@Service
public class SortViewService {

	public List<BasicView> sortBasicView(BasicView.Field field, String sortT, List<BasicView> basicViewList) {
		BasicView.field = field;
		BasicView.up = sortT.equals("up");
		Collections.sort(basicViewList);
		return basicViewList;
	}
	

}
