/**
 * 
 */
package com.iot.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.iot.dto.SearchCriteria;
import com.iot.dto.SearchOperation;
import com.iot.entity.Device;

/**
 * @author dina.hammouda
 *
 */
public class DevicesSpecifications implements Specification<Device> {

	private static final long serialVersionUID = 1L;

	private List<SearchCriteria> list;

	public DevicesSpecifications() {
		this.list = new ArrayList<>();

	}

	public void add(SearchCriteria criteria) {
		list.add(criteria);
	}

	@Override
	public Predicate toPredicate(Root<Device> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		// TODO Auto-generated method stub

		List<Predicate> predicates = new ArrayList<>();

		for (SearchCriteria criteria : list) {

			if (criteria.getOperation().equals(SearchOperation.Equal)) {
				if (criteria.getKey().equals("status")) {
					predicates.add(builder.equal(builder.lower(root.get("simId").get("status")), criteria.getValue()));
				} else if (criteria.getKey().equals("fromTemperature")) {
					predicates.add(
							builder.greaterThanOrEqualTo(root.get("fromTemperature"), criteria.getValue().toString()));

				} else if (criteria.getKey().equals("toTemperature")) {
					predicates
							.add(builder.lessThanOrEqualTo(root.get("toTemperature"), criteria.getValue().toString()));

				}

			}
		}
		return builder.and(predicates.toArray(new Predicate[0]));

	}

}