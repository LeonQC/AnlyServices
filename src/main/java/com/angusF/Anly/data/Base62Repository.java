package com.angusF.Anly.data;

import com.angusF.Anly.model.Base62Url;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Base62Repository extends JpaRepository<Base62Url, Long> {

    Base62Url getById(Long id);

    Base62Url getByLongUrl(String longUrl);
}
