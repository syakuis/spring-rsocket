package io.github.syakuis.rsocket.application;

import lombok.*;

/**
 * @author Seok Kyun. Choi.
 * @since 2021-10-26
 */
// todo 데이터 바인딩 구현...
//@Value
//@AllArgsConstructor(access = AccessLevel.PRIVATE)
//@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Message {
    String message;
}
