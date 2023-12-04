
CREATE TABLE IF NOT EXISTS project (
    id bigint auto_increment,
    type        INT,
    name        VARCHAR(256),
    code        VARCHAR(256),
    start_date  VARCHAR(256),
    end_date    VARCHAR(256),
    thumb_url   VARCHAR(256),
    format      INT,
    file_url    VARCHAR(256),
    file_md5    VARCHAR(256),
    version     VARCHAR(256),
    desc        VARCHAR(256),
    primary key (id)
);

insert into project (type,name, code, start_date, end_date,thumb_url,format,file_url,file_md5,version,desc)
values (1, '离线大数据POC', '001', '2022-11-22','2023-11-22','https://ma-hackathon-team2.obs.cn-east-3.myhuaweicloud.com/1001701326568_.pic.jpg',1,'https://ma-hackathon-team2.obs.cn-east-3.myhuaweicloud.com/detail_record_2017_01_02_08_00_00','18278f27b022afa73055bceb95d9441a','1.0.0','其他');

insert into project (type,name, code, start_date, end_date,thumb_url,format,file_url,file_md5,version,desc)
values (2, 'SOP2', '002', '2021-11-22','2023-11-22','https://ma-hackathon-team2.obs.cn-east-3.myhuaweicloud.com/1011701326582_.pic.jpg',1,'https://ma-hackathon-team2.obs.cn-east-3.myhuaweicloud.com/Logging_Ethernet_Ethernet_2023-11-09_14-41-06.asc','bb88dc029e36faf78ff20d0604082458','1.0.1','其他');