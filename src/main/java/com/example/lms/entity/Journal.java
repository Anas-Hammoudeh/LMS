package com.example.lms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "journals")
@Data
public class Journal extends LibraryItem  {

}
