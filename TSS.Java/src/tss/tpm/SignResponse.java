package tss.tpm;

import tss.*;


// -----------This is an auto-generated file: do not edit

//>>>

/** This command causes the TPM to sign an externally provided hash with the specified
 *  symmetric or asymmetric signing key.
 */
public class SignResponse extends TpmStructure
{
    /** Selector of the algorithm used to construct the signature  */
    public TPM_ALG_ID signatureSigAlg() { return signature != null ? signature.GetUnionSelector() : TPM_ALG_ID.NULL; }
    
    /** The signature  */
    public TPMU_SIGNATURE signature;
    
    public SignResponse() {}
    
    /** TpmMarshaller method  */
    @Override
    public void toTpm(TpmBuffer buf)
    {
        if (signature == null) return;
        buf.writeShort(signature.GetUnionSelector());
        signature.toTpm(buf);
    }
    
    /** TpmMarshaller method  */
    @Override
    public void initFromTpm(TpmBuffer buf)
    {
        TPM_ALG_ID signatureSigAlg = TPM_ALG_ID.fromTpm(buf);
        signature = UnionFactory.create("TPMU_SIGNATURE", signatureSigAlg);
        signature.initFromTpm(buf);
    }
    
    /** @deprecated Use {@link #toBytes()} instead  */
    public byte[] toTpm () { return toBytes(); }
    
    /** Static marshaling helper  */
    public static SignResponse fromBytes (byte[] byteBuf) 
    {
        return new TpmBuffer(byteBuf).createObj(SignResponse.class);
    }
    
    /** @deprecated Use {@link #fromBytes()} instead  */
    public static SignResponse fromTpm (byte[] byteBuf)  { return fromBytes(byteBuf); }
    
    /** Static marshaling helper  */
    public static SignResponse fromTpm (TpmBuffer buf) 
    {
        return buf.createObj(SignResponse.class);
    }
    
    @Override
    public String toString()
    {
        TpmStructurePrinter _p = new TpmStructurePrinter("TPM2_Sign_RESPONSE");
        toStringInternal(_p, 1);
        _p.endStruct();
        return _p.toString();
    }
    
    @Override
    public void toStringInternal(TpmStructurePrinter _p, int d)
    {
        _p.add(d, "TPMU_SIGNATURE", "signature", signature);
    }
}

//<<<
