package com.advspring.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class UserModel {
	private String username;
	private List<RolModel> roller = new ArrayList<RolModel>();
}
