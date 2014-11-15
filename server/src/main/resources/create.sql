CREATE TABLE Beacon (
    id VARCHAR(64) PRIMARY KEY, 
    name VARCHAR(64) NOT NULL
);

CREATE TABLE User (
    deviceID VARCHAR(128) NOT NULL, 
    name VARCHAR(32) NOT NULL,
	email VARCHAR(128),
	PRIMARY KEY(deviceID, name)
);

CREATE TABLE Message (
    id INT PRIMARY KEY, 
	text TEXT NOT NULL,
	time TIMESTAMP NOT NULL
);

CREATE TABLE BeaconMessages(
    beaconID VARCHAR(64) REFERENCES Beacon(id), 
	msgID INT REFERENCES Message(id),
	PRIMARY KEY(msgID, beaconid)
);

CREATE TABLE UserMessages (
    deviceID VARCHAR(128) REFERENCES User(id),
    name VARCHAR(32) REFERENCES User(id), 
    msgID INT REFERENCES Message(id), 
    PRIMARY KEY(deviceID, name, msgID)
);