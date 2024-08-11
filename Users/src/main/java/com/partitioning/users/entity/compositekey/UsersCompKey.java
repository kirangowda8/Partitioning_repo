package com.partitioning.users.entity.compositekey;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class UsersCompKey {
  
	private Long id;
	private Integer extractMonth;
}
