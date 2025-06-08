CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE transaction_event (
  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  account_id UUID NOT NULL,
  type VARCHAR(50) NOT NULL,
  amount NUMERIC NOT NULL,
  event_time TIMESTAMP NOT NULL
);
