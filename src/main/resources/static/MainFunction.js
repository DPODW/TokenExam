
    $(document).ready(function() {
    $("#logins").click(function(event) {
        event.preventDefault();

        const MemberData = {
            id: $("#LoginId").val(),
            pwd: $("#LoginPwd").val()
        };

        $.ajax({
            url: "/login",
            type: "POST",
            async: true,
            data: JSON.stringify(MemberData),
            contentType: 'application/json',
            success: function() {
                alert("로그인 성공");
            },
            error: function(error) {
                alert("로그인 실패")
            }
        });
    });

        $("#joins").click(function(event) {
            event.preventDefault();

            const MemberData = {
                id: $("#JoinId").val(),
                pwd: $("#JoinPwd").val(),
                role: $("input[name='role']:checked").val()
            };

            $.ajax({
                url: "/join",
                type: "POST",
                async: true,
                data: JSON.stringify(MemberData),
                contentType: 'application/json',
                success: function() {
                    alert("가입 성공");
                },
                error: function(error) {
                    alert("가입 실패")
                }
            });
        });

        $("#users").click(function(event) {
            event.preventDefault();

            $.ajax({
                url: "/user",
                type: "GET",
                success: function(response) {
                    alert("유저 권한 접근 완료");
                },
                error: function(error) {
                    console.error("Error occurred:", error);
                    alert("유저 권한 접근 실패")
                }
            });
        });

        $("#admins").click(function(event) {
            event.preventDefault();

            $.ajax({
                url: "/admin",
                type: "GET",
                success: function(response) {
                    alert("관리자 권한 접근 완료");
                },
                error: function(error) {
                    console.error("Error occurred:", error);
                    alert("관리자 권한 접근 실패")
                }
            });
        });
});
