package msa.kafka.example;

import lombok.Data;

@Data
public class GetMemberResponse {
    private Long memberId;
    private String name;

    public GetMemberResponse(Member member){
        this.memberId=member.getId();
        this.name=member.getName();
    }
}
