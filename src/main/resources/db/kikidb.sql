-- users
CREATE TABLE users (
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name        VARCHAR(255),
    email       VARCHAR(255) UNIQUE
);

-- shipments
CREATE TABLE shipments (
    id               UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    sender_id        UUID REFERENCES users(id),
    receiver_id      UUID REFERENCES users(id),
    pickup_address   VARCHAR(255),
    delivery_address VARCHAR(255),
    status           VARCHAR(50)
);

-- tracking_events
CREATE TABLE tracking_events (
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    shipment_id UUID REFERENCES shipments(id) ON DELETE CASCADE,
    location    VARCHAR(255),
    status      VARCHAR(50),
    event_time  TIMESTAMPTZ
);

-- courier_tasks
CREATE TABLE courier_tasks (
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    shipment_id UUID REFERENCES shipments(id),
    driver_id   UUID REFERENCES users(id),
    status      VARCHAR(50)
);