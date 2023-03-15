package com.angusF.Anly.data;

import com.angusF.Anly.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<Url, Long> {

    Url getByShortUrl(String shortUrl);

    Url getByLongUrl(String longUrl);
}
