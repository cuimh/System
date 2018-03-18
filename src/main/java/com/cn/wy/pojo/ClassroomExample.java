package com.cn.wy.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.cn.wy.utils.Paging;

public class ClassroomExample extends Paging implements Serializable{
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClassroomExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andClassNoIsNull() {
            addCriterion("class_no is null");
            return (Criteria) this;
        }

        public Criteria andClassNoIsNotNull() {
            addCriterion("class_no is not null");
            return (Criteria) this;
        }

        public Criteria andClassNoEqualTo(Integer value) {
            addCriterion("class_no =", value, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoNotEqualTo(Integer value) {
            addCriterion("class_no <>", value, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoGreaterThan(Integer value) {
            addCriterion("class_no >", value, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("class_no >=", value, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoLessThan(Integer value) {
            addCriterion("class_no <", value, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoLessThanOrEqualTo(Integer value) {
            addCriterion("class_no <=", value, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoIn(List<Integer> values) {
            addCriterion("class_no in", values, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoNotIn(List<Integer> values) {
            addCriterion("class_no not in", values, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoBetween(Integer value1, Integer value2) {
            addCriterion("class_no between", value1, value2, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoNotBetween(Integer value1, Integer value2) {
            addCriterion("class_no not between", value1, value2, "classNo");
            return (Criteria) this;
        }

        public Criteria andCalsspeopleIsNull() {
            addCriterion("calssPeople is null");
            return (Criteria) this;
        }

        public Criteria andCalsspeopleIsNotNull() {
            addCriterion("calssPeople is not null");
            return (Criteria) this;
        }

        public Criteria andCalsspeopleEqualTo(Integer value) {
            addCriterion("calssPeople =", value, "calsspeople");
            return (Criteria) this;
        }

        public Criteria andCalsspeopleNotEqualTo(Integer value) {
            addCriterion("calssPeople <>", value, "calsspeople");
            return (Criteria) this;
        }

        public Criteria andCalsspeopleGreaterThan(Integer value) {
            addCriterion("calssPeople >", value, "calsspeople");
            return (Criteria) this;
        }

        public Criteria andCalsspeopleGreaterThanOrEqualTo(Integer value) {
            addCriterion("calssPeople >=", value, "calsspeople");
            return (Criteria) this;
        }

        public Criteria andCalsspeopleLessThan(Integer value) {
            addCriterion("calssPeople <", value, "calsspeople");
            return (Criteria) this;
        }

        public Criteria andCalsspeopleLessThanOrEqualTo(Integer value) {
            addCriterion("calssPeople <=", value, "calsspeople");
            return (Criteria) this;
        }

        public Criteria andCalsspeopleIn(List<Integer> values) {
            addCriterion("calssPeople in", values, "calsspeople");
            return (Criteria) this;
        }

        public Criteria andCalsspeopleNotIn(List<Integer> values) {
            addCriterion("calssPeople not in", values, "calsspeople");
            return (Criteria) this;
        }

        public Criteria andCalsspeopleBetween(Integer value1, Integer value2) {
            addCriterion("calssPeople between", value1, value2, "calsspeople");
            return (Criteria) this;
        }

        public Criteria andCalsspeopleNotBetween(Integer value1, Integer value2) {
            addCriterion("calssPeople not between", value1, value2, "calsspeople");
            return (Criteria) this;
        }

        public Criteria andClassaddressIsNull() {
            addCriterion("classAddress is null");
            return (Criteria) this;
        }

        public Criteria andClassaddressIsNotNull() {
            addCriterion("classAddress is not null");
            return (Criteria) this;
        }

        public Criteria andClassaddressEqualTo(String value) {
            addCriterion("classAddress =", value, "classaddress");
            return (Criteria) this;
        }

        public Criteria andClassaddressNotEqualTo(String value) {
            addCriterion("classAddress <>", value, "classaddress");
            return (Criteria) this;
        }

        public Criteria andClassaddressGreaterThan(String value) {
            addCriterion("classAddress >", value, "classaddress");
            return (Criteria) this;
        }

        public Criteria andClassaddressGreaterThanOrEqualTo(String value) {
            addCriterion("classAddress >=", value, "classaddress");
            return (Criteria) this;
        }

        public Criteria andClassaddressLessThan(String value) {
            addCriterion("classAddress <", value, "classaddress");
            return (Criteria) this;
        }

        public Criteria andClassaddressLessThanOrEqualTo(String value) {
            addCriterion("classAddress <=", value, "classaddress");
            return (Criteria) this;
        }

        public Criteria andClassaddressLike(String value) {
            addCriterion("classAddress like", value, "classaddress");
            return (Criteria) this;
        }

        public Criteria andClassaddressNotLike(String value) {
            addCriterion("classAddress not like", value, "classaddress");
            return (Criteria) this;
        }

        public Criteria andClassaddressIn(List<String> values) {
            addCriterion("classAddress in", values, "classaddress");
            return (Criteria) this;
        }

        public Criteria andClassaddressNotIn(List<String> values) {
            addCriterion("classAddress not in", values, "classaddress");
            return (Criteria) this;
        }

        public Criteria andClassaddressBetween(String value1, String value2) {
            addCriterion("classAddress between", value1, value2, "classaddress");
            return (Criteria) this;
        }

        public Criteria andClassaddressNotBetween(String value1, String value2) {
            addCriterion("classAddress not between", value1, value2, "classaddress");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}