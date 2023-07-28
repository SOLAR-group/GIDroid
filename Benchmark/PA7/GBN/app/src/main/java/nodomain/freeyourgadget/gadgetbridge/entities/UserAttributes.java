package nodomain.freeyourgadget.gadgetbridge.entities;

import de.greenrobot.dao.AbstractDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "USER_ATTRIBUTES".
 */
public class UserAttributes implements nodomain.freeyourgadget.gadgetbridge.model.ValidByDate {

    private Long id;
    private int heightCM;
    private int weightKG;
    private Integer sleepGoalHPD;
    private Integer stepsGoalSPD;
    private java.util.Date validFromUTC;
    private java.util.Date validToUTC;
    private long userId;

    public UserAttributes() {
    }

    public UserAttributes(Long id) {
        this.id = id;
    }

    public UserAttributes(Long id, int heightCM, int weightKG, Integer sleepGoalHPD, Integer stepsGoalSPD, java.util.Date validFromUTC, java.util.Date validToUTC, long userId) {
        this.id = id;
        this.heightCM = heightCM;
        this.weightKG = weightKG;
        this.sleepGoalHPD = sleepGoalHPD;
        this.stepsGoalSPD = stepsGoalSPD;
        this.validFromUTC = validFromUTC;
        this.validToUTC = validToUTC;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getHeightCM() {
        return heightCM;
    }

    public void setHeightCM(int heightCM) {
        this.heightCM = heightCM;
    }

    public int getWeightKG() {
        return weightKG;
    }

    public void setWeightKG(int weightKG) {
        this.weightKG = weightKG;
    }

    /**
     * Desired number of hours of sleep per day.
     */
    public Integer getSleepGoalHPD() {
        return sleepGoalHPD;
    }

    /**
     * Desired number of hours of sleep per day.
     */
    public void setSleepGoalHPD(Integer sleepGoalHPD) {
        this.sleepGoalHPD = sleepGoalHPD;
    }

    /**
     * Desired number of steps per day.
     */
    public Integer getStepsGoalSPD() {
        return stepsGoalSPD;
    }

    /**
     * Desired number of steps per day.
     */
    public void setStepsGoalSPD(Integer stepsGoalSPD) {
        this.stepsGoalSPD = stepsGoalSPD;
    }

    @Override
    public java.util.Date getValidFromUTC() {
        return validFromUTC;
    }

    public void setValidFromUTC(java.util.Date validFromUTC) {
        this.validFromUTC = validFromUTC;
    }

    @Override
    public java.util.Date getValidToUTC() {
        return validToUTC;
    }

    public void setValidToUTC(java.util.Date validToUTC) {
        this.validToUTC = validToUTC;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

}
