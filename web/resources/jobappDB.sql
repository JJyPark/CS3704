/* 
 * Created by Alex Martin on 2017.03.22  * 
 * Copyright © 2017 Alex Martin. All rights reserved. * 
 */
/**
 * Author:  Jisu You
 * Created: Apr 12, 2017
 */

DROP TABLE JobApp;

CREATE TABLE JobApp
(
        id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
        time INT NOT NULL,
        company VARCHAR(256) NOT NULL,
        position VARCHAR(256) NOT NULL,
        location VARCHAR(256) NOT NULL,
        type_of_work VARCHAR(256) NOT NULL
);
