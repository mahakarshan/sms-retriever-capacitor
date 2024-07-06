export interface smsPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
