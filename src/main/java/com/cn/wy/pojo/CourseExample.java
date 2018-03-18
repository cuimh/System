package com.cn.wy.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.cn.wy.utils.Paging;

public class CourseExample extends Paging implements Serializable{
	private static final long serialVersionUID = 1L;
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseExample() {
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

        public Criteria andCourseidIsNull() {
            addCriterion("courseId is null");
            return (Criteria) this;
        }

        public Criteria andCourseidIsNotNull() {
            addCriterion("courseId is not null");
            return (Criteria) this;
        }

        public Criteria andCourseidEqualTo(Long value) {
            addCriterion("courseId =", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidNotEqualTo(Long value) {
            addCriterion("courseId <>", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidGreaterThan(Long value) {
            addCriterion("courseId >", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidGreaterThanOrEqualTo(Long value) {
            addCriterion("courseId >=", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidLessThan(Long value) {
            addCriterion("courseId <", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidLessThanOrEqualTo(Long value) {
            addCriterion("courseId <=", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidIn(List<Long> values) {
            addCriterion("courseId in", values, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidNotIn(List<Long> values) {
            addCriterion("courseId not in", values, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidBetween(Long value1, Long value2) {
            addCriterion("courseId between", value1, value2, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidNotBetween(Long value1, Long value2) {
            addCriterion("courseId not between", value1, value2, "courseid");
            return (Criteria) this;
        }

        public Criteria andTeachernoIsNull() {
            addCriterion("teacherNo is null");
            return (Criteria) this;
        }

        public Criteria andTeachernoIsNotNull() {
            addCriterion("teacherNo is not null");
            return (Criteria) this;
        }

        public Criteria andTeachernoEqualTo(Long value) {
            addCriterion("teacherNo =", value, "teacherno");
            return (Criteria) this;
        }

        public Criteria andTeachernoNotEqualTo(Long value) {
            addCriterion("teacherNo <>", value, "teacherno");
            return (Criteria) this;
        }

        public Criteria andTeachernoGreaterThan(Long value) {
            addCriterion("teacherNo >", value, "teacherno");
            return (Criteria) this;
        }

        public Criteria andTeachernoGreaterThanOrEqualTo(Long value) {
            addCriterion("teacherNo >=", value, "teacherno");
            return (Criteria) this;
        }

        public Criteria andTeachernoLessThan(Long value) {
            addCriterion("teacherNo <", value, "teacherno");
            return (Criteria) this;
        }

        public Criteria andTeachernoLessThanOrEqualTo(Long value) {
            addCriterion("teacherNo <=", value, "teacherno");
            return (Criteria) this;
        }

        public Criteria andTeachernoIn(List<Long> values) {
            addCriterion("teacherNo in", values, "teacherno");
            return (Criteria) this;
        }

        public Criteria andTeachernoNotIn(List<Long> values) {
            addCriterion("teacherNo not in", values, "teacherno");
            return (Criteria) this;
        }

        public Criteria andTeachernoBetween(Long value1, Long value2) {
            addCriterion("teacherNo between", value1, value2, "teacherno");
            return (Criteria) this;
        }

        public Criteria andTeachernoNotBetween(Long value1, Long value2) {
            addCriterion("teacherNo not between", value1, value2, "teacherno");
            return (Criteria) this;
        }

        public Criteria andCoursenameIsNull() {
            addCriterion("courseName is null");
            return (Criteria) this;
        }

        public Criteria andCoursenameIsNotNull() {
            addCriterion("courseName is not null");
            return (Criteria) this;
        }

        public Criteria andCoursenameEqualTo(String value) {
            addCriterion("courseName =", value, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameNotEqualTo(String value) {
            addCriterion("courseName <>", value, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameGreaterThan(String value) {
            addCriterion("courseName >", value, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameGreaterThanOrEqualTo(String value) {
            addCriterion("courseName >=", value, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameLessThan(String value) {
            addCriterion("courseName <", value, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameLessThanOrEqualTo(String value) {
            addCriterion("courseName <=", value, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameLike(String value) {
            addCriterion("courseName like", value, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameNotLike(String value) {
            addCriterion("courseName not like", value, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameIn(List<String> values) {
            addCriterion("courseName in", values, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameNotIn(List<String> values) {
            addCriterion("courseName not in", values, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameBetween(String value1, String value2) {
            addCriterion("courseName between", value1, value2, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameNotBetween(String value1, String value2) {
            addCriterion("courseName not between", value1, value2, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursetimeIsNull() {
            addCriterion("courseTime is null");
            return (Criteria) this;
        }

        public Criteria andCoursetimeIsNotNull() {
            addCriterion("courseTime is not null");
            return (Criteria) this;
        }

        public Criteria andCoursetimeEqualTo(String value) {
            addCriterion("courseTime =", value, "coursetime");
            return (Criteria) this;
        }

        public Criteria andCoursetimeNotEqualTo(String value) {
            addCriterion("courseTime <>", value, "coursetime");
            return (Criteria) this;
        }

        public Criteria andCoursetimeGreaterThan(String value) {
            addCriterion("courseTime >", value, "coursetime");
            return (Criteria) this;
        }

        public Criteria andCoursetimeGreaterThanOrEqualTo(String value) {
            addCriterion("courseTime >=", value, "coursetime");
            return (Criteria) this;
        }

        public Criteria andCoursetimeLessThan(String value) {
            addCriterion("courseTime <", value, "coursetime");
            return (Criteria) this;
        }

        public Criteria andCoursetimeLessThanOrEqualTo(String value) {
            addCriterion("courseTime <=", value, "coursetime");
            return (Criteria) this;
        }

        public Criteria andCoursetimeLike(String value) {
            addCriterion("courseTime like", value, "coursetime");
            return (Criteria) this;
        }

        public Criteria andCoursetimeNotLike(String value) {
            addCriterion("courseTime not like", value, "coursetime");
            return (Criteria) this;
        }

        public Criteria andCoursetimeIn(List<String> values) {
            addCriterion("courseTime in", values, "coursetime");
            return (Criteria) this;
        }

        public Criteria andCoursetimeNotIn(List<String> values) {
            addCriterion("courseTime not in", values, "coursetime");
            return (Criteria) this;
        }

        public Criteria andCoursetimeBetween(String value1, String value2) {
            addCriterion("courseTime between", value1, value2, "coursetime");
            return (Criteria) this;
        }

        public Criteria andCoursetimeNotBetween(String value1, String value2) {
            addCriterion("courseTime not between", value1, value2, "coursetime");
            return (Criteria) this;
        }

        public Criteria andCourseaddressIsNull() {
            addCriterion("courseAddress is null");
            return (Criteria) this;
        }

        public Criteria andCourseaddressIsNotNull() {
            addCriterion("courseAddress is not null");
            return (Criteria) this;
        }

        public Criteria andCourseaddressEqualTo(String value) {
            addCriterion("courseAddress =", value, "courseaddress");
            return (Criteria) this;
        }

        public Criteria andCourseaddressNotEqualTo(String value) {
            addCriterion("courseAddress <>", value, "courseaddress");
            return (Criteria) this;
        }

        public Criteria andCourseaddressGreaterThan(String value) {
            addCriterion("courseAddress >", value, "courseaddress");
            return (Criteria) this;
        }

        public Criteria andCourseaddressGreaterThanOrEqualTo(String value) {
            addCriterion("courseAddress >=", value, "courseaddress");
            return (Criteria) this;
        }

        public Criteria andCourseaddressLessThan(String value) {
            addCriterion("courseAddress <", value, "courseaddress");
            return (Criteria) this;
        }

        public Criteria andCourseaddressLessThanOrEqualTo(String value) {
            addCriterion("courseAddress <=", value, "courseaddress");
            return (Criteria) this;
        }

        public Criteria andCourseaddressLike(String value) {
            addCriterion("courseAddress like", value, "courseaddress");
            return (Criteria) this;
        }

        public Criteria andCourseaddressNotLike(String value) {
            addCriterion("courseAddress not like", value, "courseaddress");
            return (Criteria) this;
        }

        public Criteria andCourseaddressIn(List<String> values) {
            addCriterion("courseAddress in", values, "courseaddress");
            return (Criteria) this;
        }

        public Criteria andCourseaddressNotIn(List<String> values) {
            addCriterion("courseAddress not in", values, "courseaddress");
            return (Criteria) this;
        }

        public Criteria andCourseaddressBetween(String value1, String value2) {
            addCriterion("courseAddress between", value1, value2, "courseaddress");
            return (Criteria) this;
        }

        public Criteria andCourseaddressNotBetween(String value1, String value2) {
            addCriterion("courseAddress not between", value1, value2, "courseaddress");
            return (Criteria) this;
        }

        public Criteria andCourseaboutIsNull() {
            addCriterion("courseAbout is null");
            return (Criteria) this;
        }

        public Criteria andCourseaboutIsNotNull() {
            addCriterion("courseAbout is not null");
            return (Criteria) this;
        }

        public Criteria andCourseaboutEqualTo(String value) {
            addCriterion("courseAbout =", value, "courseabout");
            return (Criteria) this;
        }

        public Criteria andCourseaboutNotEqualTo(String value) {
            addCriterion("courseAbout <>", value, "courseabout");
            return (Criteria) this;
        }

        public Criteria andCourseaboutGreaterThan(String value) {
            addCriterion("courseAbout >", value, "courseabout");
            return (Criteria) this;
        }

        public Criteria andCourseaboutGreaterThanOrEqualTo(String value) {
            addCriterion("courseAbout >=", value, "courseabout");
            return (Criteria) this;
        }

        public Criteria andCourseaboutLessThan(String value) {
            addCriterion("courseAbout <", value, "courseabout");
            return (Criteria) this;
        }

        public Criteria andCourseaboutLessThanOrEqualTo(String value) {
            addCriterion("courseAbout <=", value, "courseabout");
            return (Criteria) this;
        }

        public Criteria andCourseaboutLike(String value) {
            addCriterion("courseAbout like", value, "courseabout");
            return (Criteria) this;
        }

        public Criteria andCourseaboutNotLike(String value) {
            addCriterion("courseAbout not like", value, "courseabout");
            return (Criteria) this;
        }

        public Criteria andCourseaboutIn(List<String> values) {
            addCriterion("courseAbout in", values, "courseabout");
            return (Criteria) this;
        }

        public Criteria andCourseaboutNotIn(List<String> values) {
            addCriterion("courseAbout not in", values, "courseabout");
            return (Criteria) this;
        }

        public Criteria andCourseaboutBetween(String value1, String value2) {
            addCriterion("courseAbout between", value1, value2, "courseabout");
            return (Criteria) this;
        }

        public Criteria andCourseaboutNotBetween(String value1, String value2) {
            addCriterion("courseAbout not between", value1, value2, "courseabout");
            return (Criteria) this;
        }

        public Criteria andCoursegradeIsNull() {
            addCriterion("courseGrade is null");
            return (Criteria) this;
        }

        public Criteria andCoursegradeIsNotNull() {
            addCriterion("courseGrade is not null");
            return (Criteria) this;
        }

        public Criteria andCoursegradeEqualTo(Float value) {
            addCriterion("courseGrade =", value, "coursegrade");
            return (Criteria) this;
        }

        public Criteria andCoursegradeNotEqualTo(Float value) {
            addCriterion("courseGrade <>", value, "coursegrade");
            return (Criteria) this;
        }

        public Criteria andCoursegradeGreaterThan(Float value) {
            addCriterion("courseGrade >", value, "coursegrade");
            return (Criteria) this;
        }

        public Criteria andCoursegradeGreaterThanOrEqualTo(Float value) {
            addCriterion("courseGrade >=", value, "coursegrade");
            return (Criteria) this;
        }

        public Criteria andCoursegradeLessThan(Float value) {
            addCriterion("courseGrade <", value, "coursegrade");
            return (Criteria) this;
        }

        public Criteria andCoursegradeLessThanOrEqualTo(Float value) {
            addCriterion("courseGrade <=", value, "coursegrade");
            return (Criteria) this;
        }

        public Criteria andCoursegradeIn(List<Float> values) {
            addCriterion("courseGrade in", values, "coursegrade");
            return (Criteria) this;
        }

        public Criteria andCoursegradeNotIn(List<Float> values) {
            addCriterion("courseGrade not in", values, "coursegrade");
            return (Criteria) this;
        }

        public Criteria andCoursegradeBetween(Float value1, Float value2) {
            addCriterion("courseGrade between", value1, value2, "coursegrade");
            return (Criteria) this;
        }

        public Criteria andCoursegradeNotBetween(Float value1, Float value2) {
            addCriterion("courseGrade not between", value1, value2, "coursegrade");
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

        public Criteria andClassnoIsNull() {
            addCriterion("classNo is null");
            return (Criteria) this;
        }

        public Criteria andClassnoIsNotNull() {
            addCriterion("classNo is not null");
            return (Criteria) this;
        }

        public Criteria andClassnoEqualTo(Long value) {
            addCriterion("classNo =", value, "classno");
            return (Criteria) this;
        }

        public Criteria andClassnoNotEqualTo(Long value) {
            addCriterion("classNo <>", value, "classno");
            return (Criteria) this;
        }

        public Criteria andClassnoGreaterThan(Long value) {
            addCriterion("classNo >", value, "classno");
            return (Criteria) this;
        }

        public Criteria andClassnoGreaterThanOrEqualTo(Long value) {
            addCriterion("classNo >=", value, "classno");
            return (Criteria) this;
        }

        public Criteria andClassnoLessThan(Long value) {
            addCriterion("classNo <", value, "classno");
            return (Criteria) this;
        }

        public Criteria andClassnoLessThanOrEqualTo(Long value) {
            addCriterion("classNo <=", value, "classno");
            return (Criteria) this;
        }

        public Criteria andClassnoIn(List<Long> values) {
            addCriterion("classNo in", values, "classno");
            return (Criteria) this;
        }

        public Criteria andClassnoNotIn(List<Long> values) {
            addCriterion("classNo not in", values, "classno");
            return (Criteria) this;
        }

        public Criteria andClassnoBetween(Long value1, Long value2) {
            addCriterion("classNo between", value1, value2, "classno");
            return (Criteria) this;
        }

        public Criteria andClassnoNotBetween(Long value1, Long value2) {
            addCriterion("classNo not between", value1, value2, "classno");
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