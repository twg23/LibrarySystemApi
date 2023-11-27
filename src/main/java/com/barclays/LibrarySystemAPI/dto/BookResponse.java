package com.barclays.LibrarySystemAPI.dto;

import com.barclays.LibrarySystemAPI.model.Author;
import com.barclays.LibrarySystemAPI.model.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {
    private  Long id;
    private String title;
    private List<Author> author;
    private Genre genre;

    private boolean isAvailable;
}
