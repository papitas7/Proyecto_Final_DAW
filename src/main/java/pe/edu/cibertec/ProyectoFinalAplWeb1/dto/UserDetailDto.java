package pe.edu.cibertec.ProyectoFinalAplWeb1.dto;

import java.util.Date;

public record UserDetailDto(Integer id,
                            String username,
                            String password,
                            String email,
                            String firstName,
                            String lastName,
                            String role,
                            Date createdAt,
                            Date updatedAt) {
}
