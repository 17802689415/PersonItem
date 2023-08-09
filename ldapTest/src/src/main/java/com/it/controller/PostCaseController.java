package com.it.controller;

import com.it.pojo.*;
import com.it.service.ApplyFormService;
import com.it.service.ConsignorInfoService;
import com.it.service.SampleInfoService;
import com.it.service.SampleTestInfoService;
import com.it.utils.R;
import com.it.utils.RedisCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import static com.it.controller.UserController.chars;

@Slf4j
//@CrossOrigin
@RestController
@RequestMapping("/lab")
public class PostCaseController {
    @Autowired
    private SampleTestInfoService testInfoService;

    @Autowired
    private SampleInfoService sampleFormService;

    @Autowired
    private ConsignorInfoService consignorFormService;
    @Autowired
    private ApplyFormService applyFormService;

    @Autowired
    private RedisCache redisCache;

    @GetMapping("/getNo")
//    @PreAuthorize("hasAuthority('ROLE_admin')")
    @ResponseBody
    public R<String> getNo(){
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString();
        uuid=uuid.replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 62]);
        }
        return R.success(shortBuffer.toString(),1);
    }


    @PostMapping("/postCase")
    @ResponseBody
    public R<String> test(@RequestBody CaseCommon caseCommon){
        SampleInfo sampleInfo = caseCommon.getSampleInfo();
        System.out.println(sampleInfo);
        System.out.println(caseCommon.getConsignorInfo());
        System.out.println(caseCommon.getApplyForm());
        for (SampleTestInfo s :
                caseCommon.getTestInfo()) {
            System.out.println(s);
        }

        boolean save = applyFormService.save(caseCommon.getApplyForm());
        if (save){
            boolean save1 = consignorFormService.save(caseCommon.getConsignorInfo());
            if (save1){
                boolean save2 = sampleFormService.save(caseCommon.getSampleInfo());
                if (save2){
                    for (SampleTestInfo s: caseCommon.getTestInfo()) {
                        if (s.getQuantity()>s.getLimitValue()){
                            return R.error("超出接收限值",0);
                        }
                        boolean save3 = testInfoService.save(s);
                        if (!save3){
                            return R.error("error",0);
                        }
                    }
                }
            }
        }
        return R.success("success",1);
    }
}
