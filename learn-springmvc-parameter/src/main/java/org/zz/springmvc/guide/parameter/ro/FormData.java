package org.zz.springmvc.guide.parameter.ro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormData {
    private String username;
    private MultipartFile file;
}
