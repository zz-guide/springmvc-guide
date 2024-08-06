package org.zz.springmvc.guide.parameter.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.zz.springmvc.guide.parameter.desensitization.annotation.MaskingData;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRespDTO {

    private String username;

    @MaskingData(patten = "(?<=[\\u4e00-\\u9fa5]{1})(.)")
    private String fullName; // 完整姓名

    @MaskingData(patten = "(?<=\\w{3})\\w(?=\\w{4})")
    private String phoneNo; // 手机号

    @MaskingData(patten = "(?<=\\w{6})\\w(?=\\w{1})")
    private String idNo; // 身份证号

    @MaskingData(patten = ".+", replace = "******")
    private String password; // 密码

    @MaskingData(patten = "(?<=\\w{6})\\w(?=\\w{4})")
    private String bankCardNo; // 银行卡号
}
