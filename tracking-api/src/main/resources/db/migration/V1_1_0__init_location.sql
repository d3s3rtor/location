CREATE EXTENSION IF NOT EXISTS postgis;

CREATE TABLE device (
    id UUID PRIMARY KEY,
    name TEXT NOT NULL,
    type TEXT,
    created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW(),
    last_seen_at TIMESTAMP WITHOUT TIME ZONE
);

CREATE TABLE device_location (
    id UUID PRIMARY KEY,
    device_id UUID NOT NULL REFERENCES device(id) ON DELETE CASCADE,
    location GEOGRAPHY(Point, 4326) NOT NULL,
    accuracy DOUBLE PRECISION,
    recorded_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT NOW()
);

-- Index for fast geo queries (nearest device, geofence, etc.)
CREATE INDEX idx_device_location_geom
    ON device_location USING GIST (location);

-- Index for time range queries
CREATE INDEX idx_device_location_recorded_at
    ON device_location (recorded_at);
