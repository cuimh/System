package com.cn.wy.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.cn.wy.utils.Paging;

public class TeaInfoExample extends Paging implements Serializable{
	private static final long serialVersionUID = 1L;
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeaInfoExample() {
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

        public Criteria andTernameIsNull() {
            addCriterion("tername is null");
            return (Criteria) this;
        }

        public Criteria andTernameIsNotNull() {
            addCriterion("tername is not null");
            return (Criteria) this;
        }

        public Criteria andTernameEqualTo(String value) {
            addCriterion("tername =", value, "tername");
            return (Criteria) this;
        }

        public Criteria andTernameNotEqualTo(String value) {
            addCriterion("tername <>", value, "tername");
            return (Criteria) this;
        }

        public Criteria andTernameGreaterThan(String value) {
            addCriterion("tername >", value, "tername");
            return (Criteria) this;
        }

        public Criteria andTernameGreaterThanOrEqualTo(String value) {
            addCriterion("tername >=", value, "tername");
            return (Criteria) this;
        }

        public Criteria andTernameLessThan(String value) {
            addCriterion("tername <", value, "tername");
            return (Criteria) this;
        }

        public Criteria andTernameLessThanOrEqualTo(String value) {
            addCriterion("tername <=", value, "tername");
            return (Criteria) this;
        }

        public Criteria andTernameLike(String value) {
            addCriterion("tername like", value, "tername");
            return (Criteria) this;
        }

        public Criteria andTernameNotLike(String value) {
            addCriterion("tername not like", value, "tername");
            return (Criteria) this;
        }

        public Criteria andTernameIn(List<String> values) {
            addCriterion("tername in", values, "tername");
            return (Criteria) this;
        }

        public Criteria andTernameNotIn(List<String> values) {
            addCriterion("tername not in", values, "tername");
            return (Criteria) this;
        }

        public Criteria andTernameBetween(String value1, String value2) {
            addCriterion("tername between", value1, value2, "tername");
            return (Criteria) this;
        }

        public Criteria andTernameNotBetween(String value1, String value2) {
            addCriterion("tername not between", value1, value2, "tername");
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

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Integer> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
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

        public Criteria andTeaNoIsNull() {
            addCriterion("tea_no is null");
            return (Criteria) this;
        }

        public Criteria andTeaNoIsNotNull() {
            addCriterion("tea_no is not null");
            return (Criteria) this;
        }

        public Criteria andTeaNoEqualTo(String value) {
            addCriterion("tea_no =", value, "teaNo");
            return (Criteria) this;
        }

        public Criteria andTeaNoNotEqualTo(String value) {
            addCriterion("tea_no <>", value, "teaNo");
            return (Criteria) this;
        }

        public Criteria andTeaNoGreaterThan(String value) {
            addCriterion("tea_no >", value, "teaNo");
            return (Criteria) this;
        }

        public Criteria andTeaNoGreaterThanOrEqualTo(String value) {
            addCriterion("tea_no >=", value, "teaNo");
            return (Criteria) this;
        }

        public Criteria andTeaNoLessThan(String value) {
            addCriterion("tea_no <", value, "teaNo");
            return (Criteria) this;
        }

        public Criteria andTeaNoLessThanOrEqualTo(String value) {
            addCriterion("tea_no <=", value, "teaNo");
            return (Criteria) this;
        }

        public Criteria andTeaNoLike(String value) {
            addCriterion("tea_no like", value, "teaNo");
            return (Criteria) this;
        }

        public Criteria andTeaNoNotLike(String value) {
            addCriterion("tea_no not like", value, "teaNo");
            return (Criteria) this;
        }

        public Criteria andTeaNoIn(List<String> values) {
            addCriterion("tea_no in", values, "teaNo");
            return (Criteria) this;
        }

        public Criteria andTeaNoNotIn(List<String> values) {
            addCriterion("tea_no not in", values, "teaNo");
            return (Criteria) this;
        }

        public Criteria andTeaNoBetween(String value1, String value2) {
            addCriterion("tea_no between", value1, value2, "teaNo");
            return (Criteria) this;
        }

        public Criteria andTeaNoNotBetween(String value1, String value2) {
            addCriterion("tea_no not between", value1, value2, "teaNo");
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