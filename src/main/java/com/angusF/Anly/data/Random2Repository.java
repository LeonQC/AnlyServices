package com.angusF.Anly.data;

import com.angusF.Anly.model.Random2Url;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Random2Repository extends JpaRepository<Random2Url, Long> {
    Random2Url getByShortUrl(String shortUrl);

    Random2Url getByLongUrl(String longUrl);
}
