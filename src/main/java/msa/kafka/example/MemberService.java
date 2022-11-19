package msa.kafka.example;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public String postMember(String name){
        Member member=new Member();
        member.setName(name);

        memberRepository.save(member);

        return "멤버 등록 성공";
    }

    public List<GetMemberResponse> getMembers(){
        List<Member> members=memberRepository.findAll();
        List<GetMemberResponse> result=new ArrayList<>();

        result=members.stream().map(m->new GetMemberResponse(m)).collect(Collectors.toList());

        return result;
    }

    public GetMemberResponse getMember(Long memberId){
        Member member=memberRepository.findById(memberId).get();

        return new GetMemberResponse(member);
    }
}
