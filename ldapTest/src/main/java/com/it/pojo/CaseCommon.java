package com.it.pojo;

import java.io.Serializable;
import java.util.List;

public class CaseCommon implements Serializable {
    private SampleInfo sampleInfo;
    private ConsignorInfo consignorInfo;

    private ApplyForm applyForm;

    private List<SampleTestInfo> testInfo;

    public List<SampleTestInfo> getTestInfo() {
        return testInfo;
    }

    public void setTestInfo(List<SampleTestInfo> testInfo) {
        this.testInfo = testInfo;
    }

    public ApplyForm getApplyForm() {
        return applyForm;
    }

    public void setApplyForm(ApplyForm applyForm) {
        this.applyForm = applyForm;
    }

    public SampleInfo getSampleInfo() {
        return sampleInfo;
    }

    public void setSampleInfo(SampleInfo sampleInfo) {
        this.sampleInfo = sampleInfo;
    }

    public ConsignorInfo getConsignorInfo() {
        return consignorInfo;
    }

    public void setConsignorInfo(ConsignorInfo consignorInfo) {
        this.consignorInfo = consignorInfo;
    }
}
