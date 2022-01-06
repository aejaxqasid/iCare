package com.shaikh.utils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class CustomCollectionUtils {

	public static Map<Long, String> convertToMap(List<Object[]> list) {

		return list.stream()
				.collect(
						Collectors.toMap(
								entry -> Long.valueOf(entry[0].toString()),
								entry -> entry[1].toString()));
	}
}
