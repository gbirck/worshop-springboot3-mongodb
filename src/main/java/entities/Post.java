package entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;

@Entity
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant date;
    private String title;
    private String body;



}
