# sms-retriever

auto sms retrieving in capacitor

## Install

```bash
npm install sms-retriever
npx cap sync
```

## API

<docgen-index>

* [`readSMS(...)`](#readsms)
* [`startWatching(...)`](#startwatching)
* [`stopWatching()`](#stopwatching)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

Defines the interface for the SmsReaderPlugin.

### readSMS(...)

```typescript
readSMS(options: ReadSMSOptions) => Promise<ReadSMSResult>
```

Reads the OTP from SMS messages based on the provided search string.

| Param         | Type                                                      | Description                               |
| ------------- | --------------------------------------------------------- | ----------------------------------------- |
| **`options`** | <code><a href="#readsmsoptions">ReadSMSOptions</a></code> | - An object containing the search string. |

**Returns:** <code>Promise&lt;<a href="#readsmsresult">ReadSMSResult</a>&gt;</code>

--------------------


### startWatching(...)

```typescript
startWatching(options: ReadSMSOptions) => Promise<ReadSMSResult>
```

Starts watching for SMS messages to read the OTP based on the provided search string.

| Param         | Type                                                      | Description                               |
| ------------- | --------------------------------------------------------- | ----------------------------------------- |
| **`options`** | <code><a href="#readsmsoptions">ReadSMSOptions</a></code> | - An object containing the search string. |

**Returns:** <code>Promise&lt;<a href="#readsmsresult">ReadSMSResult</a>&gt;</code>

--------------------


### stopWatching()

```typescript
stopWatching() => Promise<void>
```

Stops watching for SMS messages.

--------------------


### Interfaces


#### ReadSMSResult

Represents the result of reading SMS.

| Prop      | Type                | Description                     |
| --------- | ------------------- | ------------------------------- |
| **`otp`** | <code>string</code> | The OTP extracted from the SMS. |


#### ReadSMSOptions

Represents the options for reading SMS.

| Prop               | Type                | Description                                        |
| ------------------ | ------------------- | -------------------------------------------------- |
| **`searchString`** | <code>string</code> | The search string used to find the OTP in the SMS. |

</docgen-api>
