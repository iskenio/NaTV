package kg.megacom.natv.microservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "${micro.fileService.name}", url = "${micro.fileService.url}")
public interface FeignFileService {
    @PostMapping(value = "/api/v1/file/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    FeighFile storeFile(@RequestPart("file") MultipartFile photo);

}
