insert into user values(90001, sysdate(), 'User1', 'test111', '123456-1234567');
insert into user values(90002, sysdate(), 'User2', 'test222', '223456-1234567');
insert into user values(90003, sysdate(), 'User3', 'test333', '323456-1234567');

insert into post values(10001, 'My first post', 90001);
insert into post values(10002, 'My second post', 90001);
