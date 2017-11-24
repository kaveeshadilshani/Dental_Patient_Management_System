package com.doerit.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivityLoggerExample {
     
    protected String orderByClause;

     
    protected boolean distinct;

     
    protected List<Criteria> oredCriteria;

     
    public ActivityLoggerExample() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRelateKeyIsNull() {
            addCriterion("RELATE_KEY is null");
            return (Criteria) this;
        }

        public Criteria andRelateKeyIsNotNull() {
            addCriterion("RELATE_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andRelateKeyEqualTo(String value) {
            addCriterion("RELATE_KEY =", value, "relateKey");
            return (Criteria) this;
        }

        public Criteria andRelateKeyNotEqualTo(String value) {
            addCriterion("RELATE_KEY <>", value, "relateKey");
            return (Criteria) this;
        }

        public Criteria andRelateKeyGreaterThan(String value) {
            addCriterion("RELATE_KEY >", value, "relateKey");
            return (Criteria) this;
        }

        public Criteria andRelateKeyGreaterThanOrEqualTo(String value) {
            addCriterion("RELATE_KEY >=", value, "relateKey");
            return (Criteria) this;
        }

        public Criteria andRelateKeyLessThan(String value) {
            addCriterion("RELATE_KEY <", value, "relateKey");
            return (Criteria) this;
        }

        public Criteria andRelateKeyLessThanOrEqualTo(String value) {
            addCriterion("RELATE_KEY <=", value, "relateKey");
            return (Criteria) this;
        }

        public Criteria andRelateKeyLike(String value) {
            addCriterion("RELATE_KEY like", value, "relateKey");
            return (Criteria) this;
        }

        public Criteria andRelateKeyNotLike(String value) {
            addCriterion("RELATE_KEY not like", value, "relateKey");
            return (Criteria) this;
        }

        public Criteria andRelateKeyIn(List<String> values) {
            addCriterion("RELATE_KEY in", values, "relateKey");
            return (Criteria) this;
        }

        public Criteria andRelateKeyNotIn(List<String> values) {
            addCriterion("RELATE_KEY not in", values, "relateKey");
            return (Criteria) this;
        }

        public Criteria andRelateKeyBetween(String value1, String value2) {
            addCriterion("RELATE_KEY between", value1, value2, "relateKey");
            return (Criteria) this;
        }

        public Criteria andRelateKeyNotBetween(String value1, String value2) {
            addCriterion("RELATE_KEY not between", value1, value2, "relateKey");
            return (Criteria) this;
        }

        public Criteria andMessageTypeIsNull() {
            addCriterion("MESSAGE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andMessageTypeIsNotNull() {
            addCriterion("MESSAGE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMessageTypeEqualTo(String value) {
            addCriterion("MESSAGE_TYPE =", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNotEqualTo(String value) {
            addCriterion("MESSAGE_TYPE <>", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeGreaterThan(String value) {
            addCriterion("MESSAGE_TYPE >", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeGreaterThanOrEqualTo(String value) {
            addCriterion("MESSAGE_TYPE >=", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeLessThan(String value) {
            addCriterion("MESSAGE_TYPE <", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeLessThanOrEqualTo(String value) {
            addCriterion("MESSAGE_TYPE <=", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeLike(String value) {
            addCriterion("MESSAGE_TYPE like", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNotLike(String value) {
            addCriterion("MESSAGE_TYPE not like", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeIn(List<String> values) {
            addCriterion("MESSAGE_TYPE in", values, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNotIn(List<String> values) {
            addCriterion("MESSAGE_TYPE not in", values, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeBetween(String value1, String value2) {
            addCriterion("MESSAGE_TYPE between", value1, value2, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNotBetween(String value1, String value2) {
            addCriterion("MESSAGE_TYPE not between", value1, value2, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageIsNull() {
            addCriterion("MESSAGE is null");
            return (Criteria) this;
        }

        public Criteria andMessageIsNotNull() {
            addCriterion("MESSAGE is not null");
            return (Criteria) this;
        }

        public Criteria andMessageEqualTo(String value) {
            addCriterion("MESSAGE =", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotEqualTo(String value) {
            addCriterion("MESSAGE <>", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThan(String value) {
            addCriterion("MESSAGE >", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThanOrEqualTo(String value) {
            addCriterion("MESSAGE >=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThan(String value) {
            addCriterion("MESSAGE <", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThanOrEqualTo(String value) {
            addCriterion("MESSAGE <=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLike(String value) {
            addCriterion("MESSAGE like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotLike(String value) {
            addCriterion("MESSAGE not like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageIn(List<String> values) {
            addCriterion("MESSAGE in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotIn(List<String> values) {
            addCriterion("MESSAGE not in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageBetween(String value1, String value2) {
            addCriterion("MESSAGE between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotBetween(String value1, String value2) {
            addCriterion("MESSAGE not between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andAccessHostIsNull() {
            addCriterion("ACCESS_HOST is null");
            return (Criteria) this;
        }

        public Criteria andAccessHostIsNotNull() {
            addCriterion("ACCESS_HOST is not null");
            return (Criteria) this;
        }

        public Criteria andAccessHostEqualTo(String value) {
            addCriterion("ACCESS_HOST =", value, "accessHost");
            return (Criteria) this;
        }

        public Criteria andAccessHostNotEqualTo(String value) {
            addCriterion("ACCESS_HOST <>", value, "accessHost");
            return (Criteria) this;
        }

        public Criteria andAccessHostGreaterThan(String value) {
            addCriterion("ACCESS_HOST >", value, "accessHost");
            return (Criteria) this;
        }

        public Criteria andAccessHostGreaterThanOrEqualTo(String value) {
            addCriterion("ACCESS_HOST >=", value, "accessHost");
            return (Criteria) this;
        }

        public Criteria andAccessHostLessThan(String value) {
            addCriterion("ACCESS_HOST <", value, "accessHost");
            return (Criteria) this;
        }

        public Criteria andAccessHostLessThanOrEqualTo(String value) {
            addCriterion("ACCESS_HOST <=", value, "accessHost");
            return (Criteria) this;
        }

        public Criteria andAccessHostLike(String value) {
            addCriterion("ACCESS_HOST like", value, "accessHost");
            return (Criteria) this;
        }

        public Criteria andAccessHostNotLike(String value) {
            addCriterion("ACCESS_HOST not like", value, "accessHost");
            return (Criteria) this;
        }

        public Criteria andAccessHostIn(List<String> values) {
            addCriterion("ACCESS_HOST in", values, "accessHost");
            return (Criteria) this;
        }

        public Criteria andAccessHostNotIn(List<String> values) {
            addCriterion("ACCESS_HOST not in", values, "accessHost");
            return (Criteria) this;
        }

        public Criteria andAccessHostBetween(String value1, String value2) {
            addCriterion("ACCESS_HOST between", value1, value2, "accessHost");
            return (Criteria) this;
        }

        public Criteria andAccessHostNotBetween(String value1, String value2) {
            addCriterion("ACCESS_HOST not between", value1, value2, "accessHost");
            return (Criteria) this;
        }

        public Criteria andInsertUserIdIsNull() {
            addCriterion("INSERT_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andInsertUserIdIsNotNull() {
            addCriterion("INSERT_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andInsertUserIdEqualTo(String value) {
            addCriterion("INSERT_USER_ID =", value, "insertUserId");
            return (Criteria) this;
        }

        public Criteria andInsertUserIdNotEqualTo(String value) {
            addCriterion("INSERT_USER_ID <>", value, "insertUserId");
            return (Criteria) this;
        }

        public Criteria andInsertUserIdGreaterThan(String value) {
            addCriterion("INSERT_USER_ID >", value, "insertUserId");
            return (Criteria) this;
        }

        public Criteria andInsertUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("INSERT_USER_ID >=", value, "insertUserId");
            return (Criteria) this;
        }

        public Criteria andInsertUserIdLessThan(String value) {
            addCriterion("INSERT_USER_ID <", value, "insertUserId");
            return (Criteria) this;
        }

        public Criteria andInsertUserIdLessThanOrEqualTo(String value) {
            addCriterion("INSERT_USER_ID <=", value, "insertUserId");
            return (Criteria) this;
        }

        public Criteria andInsertUserIdLike(String value) {
            addCriterion("INSERT_USER_ID like", value, "insertUserId");
            return (Criteria) this;
        }

        public Criteria andInsertUserIdNotLike(String value) {
            addCriterion("INSERT_USER_ID not like", value, "insertUserId");
            return (Criteria) this;
        }

        public Criteria andInsertUserIdIn(List<String> values) {
            addCriterion("INSERT_USER_ID in", values, "insertUserId");
            return (Criteria) this;
        }

        public Criteria andInsertUserIdNotIn(List<String> values) {
            addCriterion("INSERT_USER_ID not in", values, "insertUserId");
            return (Criteria) this;
        }

        public Criteria andInsertUserIdBetween(String value1, String value2) {
            addCriterion("INSERT_USER_ID between", value1, value2, "insertUserId");
            return (Criteria) this;
        }

        public Criteria andInsertUserIdNotBetween(String value1, String value2) {
            addCriterion("INSERT_USER_ID not between", value1, value2, "insertUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNull() {
            addCriterion("UPDATE_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNotNull() {
            addCriterion("UPDATE_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdEqualTo(String value) {
            addCriterion("UPDATE_USER_ID =", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotEqualTo(String value) {
            addCriterion("UPDATE_USER_ID <>", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThan(String value) {
            addCriterion("UPDATE_USER_ID >", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_USER_ID >=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThan(String value) {
            addCriterion("UPDATE_USER_ID <", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_USER_ID <=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLike(String value) {
            addCriterion("UPDATE_USER_ID like", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotLike(String value) {
            addCriterion("UPDATE_USER_ID not like", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIn(List<String> values) {
            addCriterion("UPDATE_USER_ID in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotIn(List<String> values) {
            addCriterion("UPDATE_USER_ID not in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdBetween(String value1, String value2) {
            addCriterion("UPDATE_USER_ID between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotBetween(String value1, String value2) {
            addCriterion("UPDATE_USER_ID not between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andInsertDatetimeIsNull() {
            addCriterion("INSERT_DATETIME is null");
            return (Criteria) this;
        }

        public Criteria andInsertDatetimeIsNotNull() {
            addCriterion("INSERT_DATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andInsertDatetimeEqualTo(Date value) {
            addCriterion("INSERT_DATETIME =", value, "insertDatetime");
            return (Criteria) this;
        }

        public Criteria andInsertDatetimeNotEqualTo(Date value) {
            addCriterion("INSERT_DATETIME <>", value, "insertDatetime");
            return (Criteria) this;
        }

        public Criteria andInsertDatetimeGreaterThan(Date value) {
            addCriterion("INSERT_DATETIME >", value, "insertDatetime");
            return (Criteria) this;
        }

        public Criteria andInsertDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("INSERT_DATETIME >=", value, "insertDatetime");
            return (Criteria) this;
        }

        public Criteria andInsertDatetimeLessThan(Date value) {
            addCriterion("INSERT_DATETIME <", value, "insertDatetime");
            return (Criteria) this;
        }

        public Criteria andInsertDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("INSERT_DATETIME <=", value, "insertDatetime");
            return (Criteria) this;
        }

        public Criteria andInsertDatetimeIn(List<Date> values) {
            addCriterion("INSERT_DATETIME in", values, "insertDatetime");
            return (Criteria) this;
        }

        public Criteria andInsertDatetimeNotIn(List<Date> values) {
            addCriterion("INSERT_DATETIME not in", values, "insertDatetime");
            return (Criteria) this;
        }

        public Criteria andInsertDatetimeBetween(Date value1, Date value2) {
            addCriterion("INSERT_DATETIME between", value1, value2, "insertDatetime");
            return (Criteria) this;
        }

        public Criteria andInsertDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("INSERT_DATETIME not between", value1, value2, "insertDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeIsNull() {
            addCriterion("UPDATE_DATETIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeIsNotNull() {
            addCriterion("UPDATE_DATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeEqualTo(Date value) {
            addCriterion("UPDATE_DATETIME =", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeNotEqualTo(Date value) {
            addCriterion("UPDATE_DATETIME <>", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeGreaterThan(Date value) {
            addCriterion("UPDATE_DATETIME >", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_DATETIME >=", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeLessThan(Date value) {
            addCriterion("UPDATE_DATETIME <", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_DATETIME <=", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeIn(List<Date> values) {
            addCriterion("UPDATE_DATETIME in", values, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeNotIn(List<Date> values) {
            addCriterion("UPDATE_DATETIME not in", values, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_DATETIME between", value1, value2, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_DATETIME not between", value1, value2, "updateDatetime");
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