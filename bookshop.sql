
-
--
-- database: `bookstore`
--

-- -------------------------------------------------------
-- Table `book_info`
--

CREATE TABLE IF NOT EXISTS `booklist` (
  `book_id` int(12) NOT NULL AUTO_INCREMENT COMMENT 'Book_id',
  `book_name` varchar(40) NOT NULL COMMENT 'Book_name',
  `author` varchar(30) NOT NULL COMMENT 'Author',
  `publisher` varchar(40) NOT NULL COMMENT 'Publisher',
  `price` double NOT NULL COMMENT 'Original Price',
  `price_rebate` double NOT NULL COMMENT 'discount',
  `publish_date` datetime NOT NULL COMMENT 'Publisher',
  `pagecount` int(10) NOT NULL COMMENT 'page_count',
  `format` int(5) NOT NULL COMMENT 'format',
  `simple_content` mediumtext COMMENT 'abstract',
  `add_time` timestamp not null, 
  `type_id` int(5) NOT NULL COMMENT 'Book type_id',
  `book_view` varchar(300) NOT NULL DEFAULT '0' COMMENT 'Book view',
  PRIMARY KEY (`book_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COMMENT='Book information' AUTO_INCREMENT=4 ;

--
-- Insert data into `book_info`
--

INSERT INTO `booklist` (`book_id`, `book_name`, `author`, `publisher`,`price`, `price_rebate`, `publish_date`, 
`pagecount`, `format`, `simple_content`, `add_time`,`type_id`, `book_view`) VALUES
(1,'Steve Jobs', 'Jason Brook', 'Simon&Schuster',35, 7,'2011-10-24 00:00:00', 345, 16, 
'This is Steven.', '',4, './bookview/stevejobs.jpg'),
(2, 'Kite Runner', 'Khaled Hosseini ', 'Riverhead Trade',16, 6.8, '2004-04-27 00:00:00',255,16,
 'The timely and critically acclaimed debut novel that is becoming a word-of-mouth phenomenon. 
 An epic tale of fathers and sons, of friendship and betrayal, that takes us from Afghanistan 
 in the final days of the monarchy to the atrocities of the present. ', '', 5, 
 './bookview/kite_runner.jpg'),
(3, 'PHP and MySQL Web Development ', 'Laura Thomson', 'Addison-Wesley Professional', 54.99, 8, 
'2008-10-11 00:00:00', 443, 16, 'This is PHP and mysql.', '',1, './bookview/php_mysql.jpg');

-- --------------------------------------------------------

--
-- Table `book_new`
--

CREATE TABLE IF NOT EXISTS `book_type` (
  `type_id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'New ID',
  `type_name` varchar(50) NOT NULL DEFAULT '0' COMMENT 'type_name',
  PRIMARY KEY (`type_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='type' AUTO_INCREMENT=1 ;



INSERT INTO `book_type` (`type_id`, `type_name`) VALUES
(1, 'Computer Science'),
(2, 'Business'),
(3, 'Education'),
(4, 'Fiction'),
(5, 'Health'),
(6, 'Literature');




CREATE TABLE IF NOT EXISTS `netuser` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'Member serial',
  `user_name` varchar(30)  NOT NULL COMMENT 'user name',
  `user_true_name` varchar(30)  NOT NULL COMMENT 'user name',
  `user_addrress` varchar(100) DEFAULT NULL COMMENT 'address',
  `user_telephone` varchar(20)  DEFAULT NULL COMMENT 'phone',
  `user_postalcode` varchar(30)  DEFAULT NULL COMMENT 'post code',
  `user_role` int  DEFAULT '1' COMMENT 'role',
  `user_password` varchar(30) NOT NULL COMMENT 'password',
 
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8  COMMENT='member information' AUTO_INCREMENT=2 ;


--
--
-- Table `order_form`
--

CREATE TABLE IF NOT EXISTS `order_form` (
  `order_form_id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'Order ID',
  `user_id` int(10) NOT NULL COMMENT 'user_id',
  `add_time` timestamp not null;
  `status` int NOT NULL default '-1' COMMENT 'status',
  PRIMARY KEY (`order_form_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='order send information' AUTO_INCREMENT=5 ;

- Table `order_form`
--

CREATE TABLE IF NOT EXISTS `order_form_book` (
	
  `order_book_id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'Order ID',
  `order_form_id` int(10) NOT NULL;
  `book_id` int(10) NOT NULL COMMENT 'user_id',
  `book_count` int NOT NULL  COMMENT 'count',
  PRIMARY KEY (`order_book_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='order send information' AUTO_INCREMENT=5 ;


