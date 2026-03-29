-- =========================
-- DRIVER TABLE
-- =========================
CREATE TABLE driver (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        created_at TIMESTAMP NOT NULL,
                        updated_at TIMESTAMP NOT NULL,
                        name VARCHAR(255),
                        license_number VARCHAR(255) NOT NULL UNIQUE
);

-- =========================
-- PASSANGER TABLE
-- =========================
CREATE TABLE passanger (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           created_at TIMESTAMP NOT NULL,
                           updated_at TIMESTAMP NOT NULL,
                           name VARCHAR(255)
);

-- =========================
-- REVIEW TABLE
-- =========================
CREATE TABLE booking_review (
                                id BIGINT PRIMARY KEY,
                                created_at TIMESTAMP NOT NULL,
                                updated_at TIMESTAMP NOT NULL,
                                content VARCHAR(255) NOT NULL,
                                rating DOUBLE
);

-- =========================
-- PASSANGER REVIEW TABLE
-- =========================
CREATE TABLE passanger_review (
                                  id BIGINT PRIMARY KEY,
                                  passanger_review_content VARCHAR(255) NOT NULL,
                                  passanger_rating DOUBLE NOT NULL,
                                  CONSTRAINT fk_passanger_review_review
                                      FOREIGN KEY (id) REFERENCES booking_review(id)
);

-- =========================
-- BOOKING TABLE
-- =========================
CREATE TABLE booking (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         created_at TIMESTAMP NOT NULL,
                         updated_at TIMESTAMP NOT NULL,

                         booking_status VARCHAR(50) CHECK (
                             booking_status IN (
                                                'SCHEDULE',
                                                'CANCELLED',
                                                'CAR_ARRIVED',
                                                'ASSIGNING_DRIVER',
                                                'IN_RIDE',
                                                'COMPLETED'
                                 )
                             ),

                         start_date TIMESTAMP,
                         end_date TIMESTAMP,
                         total_distance BIGINT,

                         driver_id BIGINT,
                         passanger_id BIGINT,
                         review_id BIGINT UNIQUE,

                         CONSTRAINT fk_booking_driver
                             FOREIGN KEY (driver_id) REFERENCES driver(id),

                         CONSTRAINT fk_booking_passanger
                             FOREIGN KEY (passanger_id) REFERENCES passanger(id),

                         CONSTRAINT fk_booking_review
                             FOREIGN KEY (review_id) REFERENCES booking_review(id)
);