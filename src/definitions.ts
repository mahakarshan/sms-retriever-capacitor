/**
 * Represents the options for reading SMS.
 */
export interface ReadSMSOptions {
  /**
   * The search string used to find the OTP in the SMS.
   */
  searchString: string;
}

/**
 * Represents the result of reading SMS.
 */
export interface ReadSMSResult {
  /**
   * The OTP extracted from the SMS.
   */
  otp: string;
}

/**
 * Defines the interface for the SmsReaderPlugin.
 */
export interface SmsReaderPlugin {
  /**
   * Reads the OTP from SMS messages based on the provided search string.
   * @param options - An object containing the search string.
   * @returns A promise that resolves with an object containing the OTP.
   */
  readSMS(options: ReadSMSOptions): Promise<ReadSMSResult>;

  /**
   * Starts watching for SMS messages to read the OTP based on the provided search string.
   * @param options - An object containing the search string.
   * @returns A promise that resolves when the watching starts.
   */
  startWatching(options: ReadSMSOptions): Promise<ReadSMSResult>;

  /**
   * Stops watching for SMS messages.
   * @returns A promise that resolves when the watching stops.
   */
  stopWatching(): Promise<void>;
}
