package gdsc.cau.alert.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;

@Configuration
public class FirebaseConfig {

    @Bean
    public FirebaseAuth firebaseAuth() throws IOException {
        // Base64 인코딩된 JSON 키 파일 읽기
        String base64EncodedKey = System.getenv("FIREBASE_JSON_KEY");

        // Base64 디코딩
        byte[] decodedKey = Base64.getDecoder().decode(base64EncodedKey);

        // 바이트 배열에서 InputStream 생성
        ByteArrayInputStream serviceAccountStream = new ByteArrayInputStream(decodedKey);

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccountStream))
                .build();
        FirebaseApp.initializeApp(options);
        return FirebaseAuth.getInstance();
    }
}
