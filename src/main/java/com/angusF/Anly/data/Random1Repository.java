package com.angusF.Anly.data;

import com.angusF.Anly.model.Random1Url;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Random1Repository extends JpaRepository<Random1Url, Long> {

    Random1Url getByShortUrl(String shortUrl);

    Random1Url getByLongUrl(String longUrl);
}
