package tss.tpm;

import tss.*;


// -----------This is an auto-generated file: do not edit

//>>>

/** This command returns the current value of the command audit digest, a digest of the
 *  commands being audited, and the audit hash algorithm. These values are placed in an
 *  attestation structure and signed with the key referenced by signHandle.
 */
public class GetCommandAuditDigestResponse extends TpmStructure
{
    /** The auditInfo that was signed  */
    public TPMS_ATTEST auditInfo;
    
    /** Selector of the algorithm used to construct the signature  */
    public TPM_ALG_ID signatureSigAlg() { return signature != null ? signature.GetUnionSelector() : TPM_ALG_ID.NULL; }
    
    /** The signature over auditInfo  */
    public TPMU_SIGNATURE signature;
    
    public GetCommandAuditDigestResponse() {}
    
    /** TpmMarshaller method  */
    @Override
    public void toTpm(TpmBuffer buf)
    {
        buf.writeSizedObj(auditInfo);
        buf.writeShort(signature.GetUnionSelector());
        signature.toTpm(buf);
    }
    
    /** TpmMarshaller method  */
    @Override
    public void initFromTpm(TpmBuffer buf)
    {
        auditInfo = buf.createSizedObj(TPMS_ATTEST.class);
        TPM_ALG_ID signatureSigAlg = TPM_ALG_ID.fromTpm(buf);
        signature = UnionFactory.create("TPMU_SIGNATURE", signatureSigAlg);
        signature.initFromTpm(buf);
    }
    
    /** @deprecated Use {@link #toBytes()} instead  */
    public byte[] toTpm () { return toBytes(); }
    
    /** Static marshaling helper  */
    public static GetCommandAuditDigestResponse fromBytes (byte[] byteBuf) 
    {
        return new TpmBuffer(byteBuf).createObj(GetCommandAuditDigestResponse.class);
    }
    
    /** @deprecated Use {@link #fromBytes()} instead  */
    public static GetCommandAuditDigestResponse fromTpm (byte[] byteBuf)  { return fromBytes(byteBuf); }
    
    /** Static marshaling helper  */
    public static GetCommandAuditDigestResponse fromTpm (TpmBuffer buf) 
    {
        return buf.createObj(GetCommandAuditDigestResponse.class);
    }
    
    @Override
    public String toString()
    {
        TpmStructurePrinter _p = new TpmStructurePrinter("TPM2_GetCommandAuditDigest_RESPONSE");
        toStringInternal(_p, 1);
        _p.endStruct();
        return _p.toString();
    }
    
    @Override
    public void toStringInternal(TpmStructurePrinter _p, int d)
    {
        _p.add(d, "TPMS_ATTEST", "auditInfo", auditInfo);
        _p.add(d, "TPMU_SIGNATURE", "signature", signature);
    }
}

//<<<
