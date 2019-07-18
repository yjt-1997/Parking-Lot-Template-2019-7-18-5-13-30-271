create table `parking_order`(
    `id` int auto_increment primary key,
    `parking_lot_name` varchar(255),
    `car_number` varchar(255),
    `create_time` bigint,
    `end_time` bigint,
    `order_status` smallint
)