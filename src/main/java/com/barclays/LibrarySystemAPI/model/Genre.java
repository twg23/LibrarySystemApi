package com.barclays.LibrarySystemAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;


public enum Genre {
    FICTION,
    ROMANCE,
    ACTION,
    SCIENTIFIC,
    THRILLER
}
