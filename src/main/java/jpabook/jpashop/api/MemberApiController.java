package jpabook.jpashop.api;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@RestController
@RequiredArgsConstructor
public class MemberApiController{
    private final MemberService memberService;

    @PostMapping("/api/v1/members")
    public CreateMemberResponse saveMemberV1(@RequestBody @Valid Member member){
        Long id = memberService.join(member);
        return new CreateMemberResponse(id);
    }
    //==점점 버전 업==//
    @PostMapping("/api/v2/members")
    public CreateMemberResponse saveMemberV2(@RequestBody @Valid CreateMemberRequest request){
        Member member = new Member();
        member.setName(request.getName());
        Long id = memberService.join(member);
        return new CreateMemberResponse(id);
    }

    @PutMapping("/api/v2/members/{id}")
    public UpdateMemberResponse updateMemberV2(@PathVariable("id") Long id ,
                                              @RequestBody @Valid UpdateMemberRequest request){
        memberService.update(id , request.getName());
        Member findMember = memberService.findOne(id);
        return new UpdateMemberResponse(findMember.getId() , findMember.getName());
    }

    @Data
    static class CreateMemberRequest{
        @NotEmpty(message = "값이 비어 있을수 없습니다.")
        @Length(max = 10,message = "열자 이상 넘을수 없습니다.")
        private String name;
    }

    @Data
    static class CreateMemberResponse{
        public CreateMemberResponse(Long id){
            this.id = id;
        }
        private Long id;
    }

    @Data
    static class UpdateMemberRequest{
        private String name;

    }
    @Data
    @AllArgsConstructor
    static class UpdateMemberResponse{
        private Long id;
        private String name;

    }

}
