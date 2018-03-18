package com.cn.wy.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cn.wy.utils.Paging;

public class UserExample extends Paging implements Serializable{

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPwdIsNull() {
            addCriterion("pwd is null");
            return (Criteria) this;
        }

        public Criteria andPwdIsNotNull() {
            addCriterion("pwd is not null");
            return (Criteria) this;
        }

        public Criteria andPwdEqualTo(String value) {
            addCriterion("pwd =", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotEqualTo(String value) {
            addCriterion("pwd <>", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdGreaterThan(String value) {
            addCriterion("pwd >", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdGreaterThanOrEqualTo(String value) {
            addCriterion("pwd >=", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLessThan(String value) {
            addCriterion("pwd <", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLessThanOrEqualTo(String value) {
            addCriterion("pwd <=", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLike(String value) {
            addCriterion("pwd like", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotLike(String value) {
            addCriterion("pwd not like", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdIn(List<String> values) {
            addCriterion("pwd in", values, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotIn(List<String> values) {
            addCriterion("pwd not in", values, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdBetween(String value1, String value2) {
            addCriterion("pwd between", value1, value2, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotBetween(String value1, String value2) {
            addCriterion("pwd not between", value1, value2, "pwd");
            return (Criteria) this;
        }

        public Criteria andRelnameIsNull() {
            addCriterion("relname is null");
            return (Criteria) this;
        }

        public Criteria andRelnameIsNotNull() {
            addCriterion("relname is not null");
            return (Criteria) this;
        }

        public Criteria andRelnameEqualTo(String value) {
            addCriterion("relname =", value, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameNotEqualTo(String value) {
            addCriterion("relname <>", value, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameGreaterThan(String value) {
            addCriterion("relname >", value, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameGreaterThanOrEqualTo(String value) {
            addCriterion("relname >=", value, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameLessThan(String value) {
            addCriterion("relname <", value, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameLessThanOrEqualTo(String value) {
            addCriterion("relname <=", value, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameLike(String value) {
            addCriterion("relname like", value, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameNotLike(String value) {
            addCriterion("relname not like", value, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameIn(List<String> values) {
            addCriterion("relname in", values, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameNotIn(List<String> values) {
            addCriterion("relname not in", values, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameBetween(String value1, String value2) {
            addCriterion("relname between", value1, value2, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameNotBetween(String value1, String value2) {
            addCriterion("relname not between", value1, value2, "relname");
            return (Criteria) this;
        }

        public Criteria andPositionidIsNull() {
            addCriterion("positionId is null");
            return (Criteria) this;
        }

        public Criteria andPositionidIsNotNull() {
            addCriterion("positionId is not null");
            return (Criteria) this;
        }

        public Criteria andPositionidEqualTo(String value) {
            addCriterion("positionId =", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidNotEqualTo(String value) {
            addCriterion("positionId <>", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidGreaterThan(String value) {
            addCriterion("positionId >", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidGreaterThanOrEqualTo(String value) {
            addCriterion("positionId >=", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidLessThan(String value) {
            addCriterion("positionId <", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidLessThanOrEqualTo(String value) {
            addCriterion("positionId <=", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidLike(String value) {
            addCriterion("positionId like", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidNotLike(String value) {
            addCriterion("positionId not like", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidIn(List<String> values) {
            addCriterion("positionId in", values, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidNotIn(List<String> values) {
            addCriterion("positionId not in", values, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidBetween(String value1, String value2) {
            addCriterion("positionId between", value1, value2, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidNotBetween(String value1, String value2) {
            addCriterion("positionId not between", value1, value2, "positionid");
            return (Criteria) this;
        }

        public Criteria andInstructionsIsNull() {
            addCriterion("instructions is null");
            return (Criteria) this;
        }

        public Criteria andInstructionsIsNotNull() {
            addCriterion("instructions is not null");
            return (Criteria) this;
        }

        public Criteria andInstructionsEqualTo(String value) {
            addCriterion("instructions =", value, "instructions");
            return (Criteria) this;
        }

        public Criteria andInstructionsNotEqualTo(String value) {
            addCriterion("instructions <>", value, "instructions");
            return (Criteria) this;
        }

        public Criteria andInstructionsGreaterThan(String value) {
            addCriterion("instructions >", value, "instructions");
            return (Criteria) this;
        }

        public Criteria andInstructionsGreaterThanOrEqualTo(String value) {
            addCriterion("instructions >=", value, "instructions");
            return (Criteria) this;
        }

        public Criteria andInstructionsLessThan(String value) {
            addCriterion("instructions <", value, "instructions");
            return (Criteria) this;
        }

        public Criteria andInstructionsLessThanOrEqualTo(String value) {
            addCriterion("instructions <=", value, "instructions");
            return (Criteria) this;
        }

        public Criteria andInstructionsLike(String value) {
            addCriterion("instructions like", value, "instructions");
            return (Criteria) this;
        }

        public Criteria andInstructionsNotLike(String value) {
            addCriterion("instructions not like", value, "instructions");
            return (Criteria) this;
        }

        public Criteria andInstructionsIn(List<String> values) {
            addCriterion("instructions in", values, "instructions");
            return (Criteria) this;
        }

        public Criteria andInstructionsNotIn(List<String> values) {
            addCriterion("instructions not in", values, "instructions");
            return (Criteria) this;
        }

        public Criteria andInstructionsBetween(String value1, String value2) {
            addCriterion("instructions between", value1, value2, "instructions");
            return (Criteria) this;
        }

        public Criteria andInstructionsNotBetween(String value1, String value2) {
            addCriterion("instructions not between", value1, value2, "instructions");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andModifytimeIsNull() {
            addCriterion("modifytime is null");
            return (Criteria) this;
        }

        public Criteria andModifytimeIsNotNull() {
            addCriterion("modifytime is not null");
            return (Criteria) this;
        }

        public Criteria andModifytimeEqualTo(Date value) {
            addCriterion("modifytime =", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotEqualTo(Date value) {
            addCriterion("modifytime <>", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeGreaterThan(Date value) {
            addCriterion("modifytime >", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modifytime >=", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeLessThan(Date value) {
            addCriterion("modifytime <", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeLessThanOrEqualTo(Date value) {
            addCriterion("modifytime <=", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeIn(List<Date> values) {
            addCriterion("modifytime in", values, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotIn(List<Date> values) {
            addCriterion("modifytime not in", values, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeBetween(Date value1, Date value2) {
            addCriterion("modifytime between", value1, value2, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotBetween(Date value1, Date value2) {
            addCriterion("modifytime not between", value1, value2, "modifytime");
            return (Criteria) this;
        }
        public Criteria andFlagEqualTo(Integer value) {
			addCriterion("flag =", value, "flag");
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