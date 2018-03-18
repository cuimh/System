package com.cn.wy.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.cn.wy.utils.Paging;

public class PersissionExample extends Paging implements Serializable{
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PersissionExample() {
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

        public Criteria andPermisnameIsNull() {
            addCriterion("permisname is null");
            return (Criteria) this;
        }

        public Criteria andPermisnameIsNotNull() {
            addCriterion("permisname is not null");
            return (Criteria) this;
        }

        public Criteria andPermisnameEqualTo(String value) {
            addCriterion("permisname =", value, "permisname");
            return (Criteria) this;
        }

        public Criteria andPermisnameNotEqualTo(String value) {
            addCriterion("permisname <>", value, "permisname");
            return (Criteria) this;
        }

        public Criteria andPermisnameGreaterThan(String value) {
            addCriterion("permisname >", value, "permisname");
            return (Criteria) this;
        }

        public Criteria andPermisnameGreaterThanOrEqualTo(String value) {
            addCriterion("permisname >=", value, "permisname");
            return (Criteria) this;
        }

        public Criteria andPermisnameLessThan(String value) {
            addCriterion("permisname <", value, "permisname");
            return (Criteria) this;
        }

        public Criteria andPermisnameLessThanOrEqualTo(String value) {
            addCriterion("permisname <=", value, "permisname");
            return (Criteria) this;
        }

        public Criteria andPermisnameLike(String value) {
            addCriterion("permisname like", value, "permisname");
            return (Criteria) this;
        }

        public Criteria andPermisnameNotLike(String value) {
            addCriterion("permisname not like", value, "permisname");
            return (Criteria) this;
        }

        public Criteria andPermisnameIn(List<String> values) {
            addCriterion("permisname in", values, "permisname");
            return (Criteria) this;
        }

        public Criteria andPermisnameNotIn(List<String> values) {
            addCriterion("permisname not in", values, "permisname");
            return (Criteria) this;
        }

        public Criteria andPermisnameBetween(String value1, String value2) {
            addCriterion("permisname between", value1, value2, "permisname");
            return (Criteria) this;
        }

        public Criteria andPermisnameNotBetween(String value1, String value2) {
            addCriterion("permisname not between", value1, value2, "permisname");
            return (Criteria) this;
        }

        public Criteria andPathIsNull() {
            addCriterion("path is null");
            return (Criteria) this;
        }

        public Criteria andPathIsNotNull() {
            addCriterion("path is not null");
            return (Criteria) this;
        }

        public Criteria andPathEqualTo(String value) {
            addCriterion("path =", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotEqualTo(String value) {
            addCriterion("path <>", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThan(String value) {
            addCriterion("path >", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThanOrEqualTo(String value) {
            addCriterion("path >=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThan(String value) {
            addCriterion("path <", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThanOrEqualTo(String value) {
            addCriterion("path <=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLike(String value) {
            addCriterion("path like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotLike(String value) {
            addCriterion("path not like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathIn(List<String> values) {
            addCriterion("path in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotIn(List<String> values) {
            addCriterion("path not in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathBetween(String value1, String value2) {
            addCriterion("path between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotBetween(String value1, String value2) {
            addCriterion("path not between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andPermisorderIsNull() {
            addCriterion("permisOrder is null");
            return (Criteria) this;
        }

        public Criteria andPermisorderIsNotNull() {
            addCriterion("permisOrder is not null");
            return (Criteria) this;
        }

        public Criteria andPermisorderEqualTo(String value) {
            addCriterion("permisOrder =", value, "permisorder");
            return (Criteria) this;
        }

        public Criteria andPermisorderNotEqualTo(String value) {
            addCriterion("permisOrder <>", value, "permisorder");
            return (Criteria) this;
        }

        public Criteria andPermisorderGreaterThan(String value) {
            addCriterion("permisOrder >", value, "permisorder");
            return (Criteria) this;
        }

        public Criteria andPermisorderGreaterThanOrEqualTo(String value) {
            addCriterion("permisOrder >=", value, "permisorder");
            return (Criteria) this;
        }

        public Criteria andPermisorderLessThan(String value) {
            addCriterion("permisOrder <", value, "permisorder");
            return (Criteria) this;
        }

        public Criteria andPermisorderLessThanOrEqualTo(String value) {
            addCriterion("permisOrder <=", value, "permisorder");
            return (Criteria) this;
        }

        public Criteria andPermisorderLike(String value) {
            addCriterion("permisOrder like", value, "permisorder");
            return (Criteria) this;
        }

        public Criteria andPermisorderNotLike(String value) {
            addCriterion("permisOrder not like", value, "permisorder");
            return (Criteria) this;
        }

        public Criteria andPermisorderIn(List<String> values) {
            addCriterion("permisOrder in", values, "permisorder");
            return (Criteria) this;
        }

        public Criteria andPermisorderNotIn(List<String> values) {
            addCriterion("permisOrder not in", values, "permisorder");
            return (Criteria) this;
        }

        public Criteria andPermisorderBetween(String value1, String value2) {
            addCriterion("permisOrder between", value1, value2, "permisorder");
            return (Criteria) this;
        }

        public Criteria andPermisorderNotBetween(String value1, String value2) {
            addCriterion("permisOrder not between", value1, value2, "permisorder");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Integer value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Integer value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Integer value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Integer value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Integer value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Integer> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Integer> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Integer value1, Integer value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Integer value1, Integer value2) {
            addCriterion("pid not between", value1, value2, "pid");
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