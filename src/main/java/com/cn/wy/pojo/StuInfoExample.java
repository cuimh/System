package com.cn.wy.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.cn.wy.utils.Paging;

public class StuInfoExample extends Paging implements Serializable{
	private static final long serialVersionUID = 1L;
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StuInfoExample() {
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

        public Criteria andStuNoIsNull() {
            addCriterion("stu_no is null");
            return (Criteria) this;
        }

        public Criteria andStuNoIsNotNull() {
            addCriterion("stu_no is not null");
            return (Criteria) this;
        }

        public Criteria andStuNoEqualTo(String value) {
            addCriterion("stu_no =", value, "stuNo");
            return (Criteria) this;
        }

        public Criteria andStuNoNotEqualTo(String value) {
            addCriterion("stu_no <>", value, "stuNo");
            return (Criteria) this;
        }

        public Criteria andStuNoGreaterThan(String value) {
            addCriterion("stu_no >", value, "stuNo");
            return (Criteria) this;
        }

        public Criteria andStuNoGreaterThanOrEqualTo(String value) {
            addCriterion("stu_no >=", value, "stuNo");
            return (Criteria) this;
        }

        public Criteria andStuNoLessThan(String value) {
            addCriterion("stu_no <", value, "stuNo");
            return (Criteria) this;
        }

        public Criteria andStuNoLessThanOrEqualTo(String value) {
            addCriterion("stu_no <=", value, "stuNo");
            return (Criteria) this;
        }

        public Criteria andStuNoLike(String value) {
            addCriterion("stu_no like", value, "stuNo");
            return (Criteria) this;
        }

        public Criteria andStuNoNotLike(String value) {
            addCriterion("stu_no not like", value, "stuNo");
            return (Criteria) this;
        }

        public Criteria andStuNoIn(List<String> values) {
            addCriterion("stu_no in", values, "stuNo");
            return (Criteria) this;
        }

        public Criteria andStuNoNotIn(List<String> values) {
            addCriterion("stu_no not in", values, "stuNo");
            return (Criteria) this;
        }

        public Criteria andStuNoBetween(String value1, String value2) {
            addCriterion("stu_no between", value1, value2, "stuNo");
            return (Criteria) this;
        }

        public Criteria andStuNoNotBetween(String value1, String value2) {
            addCriterion("stu_no not between", value1, value2, "stuNo");
            return (Criteria) this;
        }

        public Criteria andStunameIsNull() {
            addCriterion("stuname is null");
            return (Criteria) this;
        }

        public Criteria andStunameIsNotNull() {
            addCriterion("stuname is not null");
            return (Criteria) this;
        }

        public Criteria andStunameEqualTo(String value) {
            addCriterion("stuname =", value, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameNotEqualTo(String value) {
            addCriterion("stuname <>", value, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameGreaterThan(String value) {
            addCriterion("stuname >", value, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameGreaterThanOrEqualTo(String value) {
            addCriterion("stuname >=", value, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameLessThan(String value) {
            addCriterion("stuname <", value, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameLessThanOrEqualTo(String value) {
            addCriterion("stuname <=", value, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameLike(String value) {
            addCriterion("stuname like", value, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameNotLike(String value) {
            addCriterion("stuname not like", value, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameIn(List<String> values) {
            addCriterion("stuname in", values, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameNotIn(List<String> values) {
            addCriterion("stuname not in", values, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameBetween(String value1, String value2) {
            addCriterion("stuname between", value1, value2, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameNotBetween(String value1, String value2) {
            addCriterion("stuname not between", value1, value2, "stuname");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andZidIsNull() {
            addCriterion("zId is null");
            return (Criteria) this;
        }

        public Criteria andZidIsNotNull() {
            addCriterion("zId is not null");
            return (Criteria) this;
        }

        public Criteria andZidEqualTo(Long value) {
            addCriterion("zId =", value, "zid");
            return (Criteria) this;
        }

        public Criteria andZidNotEqualTo(Long value) {
            addCriterion("zId <>", value, "zid");
            return (Criteria) this;
        }

        public Criteria andZidGreaterThan(Long value) {
            addCriterion("zId >", value, "zid");
            return (Criteria) this;
        }

        public Criteria andZidGreaterThanOrEqualTo(Long value) {
            addCriterion("zId >=", value, "zid");
            return (Criteria) this;
        }

        public Criteria andZidLessThan(Long value) {
            addCriterion("zId <", value, "zid");
            return (Criteria) this;
        }

        public Criteria andZidLessThanOrEqualTo(Long value) {
            addCriterion("zId <=", value, "zid");
            return (Criteria) this;
        }

        public Criteria andZidIn(List<Long> values) {
            addCriterion("zId in", values, "zid");
            return (Criteria) this;
        }

        public Criteria andZidNotIn(List<Long> values) {
            addCriterion("zId not in", values, "zid");
            return (Criteria) this;
        }

        public Criteria andZidBetween(Long value1, Long value2) {
            addCriterion("zId between", value1, value2, "zid");
            return (Criteria) this;
        }

        public Criteria andZidNotBetween(Long value1, Long value2) {
            addCriterion("zId not between", value1, value2, "zid");
            return (Criteria) this;
        }

        public Criteria andDepartidIsNull() {
            addCriterion("departId is null");
            return (Criteria) this;
        }

        public Criteria andDepartidIsNotNull() {
            addCriterion("departId is not null");
            return (Criteria) this;
        }

        public Criteria andDepartidEqualTo(Long value) {
            addCriterion("departId =", value, "departid");
            return (Criteria) this;
        }

        public Criteria andDepartidNotEqualTo(Long value) {
            addCriterion("departId <>", value, "departid");
            return (Criteria) this;
        }

        public Criteria andDepartidGreaterThan(Long value) {
            addCriterion("departId >", value, "departid");
            return (Criteria) this;
        }

        public Criteria andDepartidGreaterThanOrEqualTo(Long value) {
            addCriterion("departId >=", value, "departid");
            return (Criteria) this;
        }

        public Criteria andDepartidLessThan(Long value) {
            addCriterion("departId <", value, "departid");
            return (Criteria) this;
        }

        public Criteria andDepartidLessThanOrEqualTo(Long value) {
            addCriterion("departId <=", value, "departid");
            return (Criteria) this;
        }

        public Criteria andDepartidIn(List<Long> values) {
            addCriterion("departId in", values, "departid");
            return (Criteria) this;
        }

        public Criteria andDepartidNotIn(List<Long> values) {
            addCriterion("departId not in", values, "departid");
            return (Criteria) this;
        }

        public Criteria andDepartidBetween(Long value1, Long value2) {
            addCriterion("departId between", value1, value2, "departid");
            return (Criteria) this;
        }

        public Criteria andDepartidNotBetween(Long value1, Long value2) {
            addCriterion("departId not between", value1, value2, "departid");
            return (Criteria) this;
        }

       
        public Criteria andStuclassIsNull() {
            addCriterion("stuClass is null");
            return (Criteria) this;
        }

        public Criteria andStuclassIsNotNull() {
            addCriterion("stuClass is not null");
            return (Criteria) this;
        }

        public Criteria andStuclassEqualTo(Integer value) {
            addCriterion("stuClass =", value, "stuclass");
            return (Criteria) this;
        }

        public Criteria andStuclassNotEqualTo(Integer value) {
            addCriterion("stuClass <>", value, "stuclass");
            return (Criteria) this;
        }

        public Criteria andStuclassGreaterThan(Integer value) {
            addCriterion("stuClass >", value, "stuclass");
            return (Criteria) this;
        }

        public Criteria andStuclassGreaterThanOrEqualTo(Integer value) {
            addCriterion("stuClass >=", value, "stuclass");
            return (Criteria) this;
        }

        public Criteria andStuclassLessThan(Integer value) {
            addCriterion("stuClass <", value, "stuclass");
            return (Criteria) this;
        }

        public Criteria andStuclassLessThanOrEqualTo(Integer value) {
            addCriterion("stuClass <=", value, "stuclass");
            return (Criteria) this;
        }

        public Criteria andStuclassIn(List<Integer> values) {
            addCriterion("stuClass in", values, "stuclass");
            return (Criteria) this;
        }

        public Criteria andStuclassNotIn(List<Integer> values) {
            addCriterion("stuClass not in", values, "stuclass");
            return (Criteria) this;
        }

        public Criteria andStuclassBetween(Integer value1, Integer value2) {
            addCriterion("stuClass between", value1, value2, "stuclass");
            return (Criteria) this;
        }

        public Criteria andStuclassNotBetween(Integer value1, Integer value2) {
            addCriterion("stuClass not between", value1, value2, "stuclass");
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