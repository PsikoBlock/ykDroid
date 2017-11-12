package net.pp3345.yubidroid.yubikey;

public enum Slot {
	DUMMY((byte) 0x0),
	CONFIG_1((byte) 0x1),
	NAV((byte) 0x2),
	CONFIG_2((byte) 0x3),
	UPDATE_1((byte) 0x4),
	UPDATE_2((byte) 0x5),
	SWAP((byte) 0x6),
	NDEF_1((byte) 0x8),
	NDEF_2((byte) 0x9),
	DEVICE_SERIAL((byte) 0x10),
	DEVICE_CONFIGURATION((byte) 0x11),
	SCAN_MAP((byte) 0x12),
	YUBIKEY_4_CAPABILITIES((byte) 0x13),
	CHALLENGE_OTP_1((byte) 0x20),
	CHALLENGE_OTP_2((byte) 0x28),
	CHALLENGE_HMAC_1((byte) 0x30),
	CHALLENGE_HMAC_2((byte) 0x38);

	private final byte address;

	Slot(final byte address) {
		this.address = address;
	}

	public byte getAddress() {
		return this.address;
	}

	public boolean isChallengeResponseSlot() {
		return this == CHALLENGE_HMAC_1 || this == CHALLENGE_HMAC_2;
	}

	public void ensureChallengeResponseSlot() throws InvalidSlotException {
		if (!this.isChallengeResponseSlot())
			throw new InvalidSlotException();
	}
}
